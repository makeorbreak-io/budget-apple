//
//  ItemTableViewController.swift
//  PiDrobe
//
//  Created by Luis Goncalves on 09/09/2017.
//  Copyright © 2017 Budget Apple. All rights reserved.
//

import UIKit
import os.log

class ItemTableViewController: UITableViewController {
    
    // MARK: - Properties
    @IBOutlet weak var addButton: UIBarButtonItem!
    var items = [[Item]]()
    var categories = [Category]()

    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        generateCategories()
        loadItems()
        
        self.refreshControl?.attributedTitle = NSAttributedString(string: "Pull to refresh")
        self.refreshControl?.addTarget(self, action: #selector(refresh), for: UIControlEvents.valueChanged)

        
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem()
    }
    
    func refresh(sender:AnyObject){
        loadItems()
        self.refreshControl?.endRefreshing()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return categories.count
    }
    
    override func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return self.categories[section].category
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return items[section].count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // Table view cells are reused and should be dequeued using a cell identifier.
        let cellIdentifier = "ItemCell"
        
        guard let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier, for: indexPath) as? ItemTableViewCell  else {
            fatalError("The dequeued cell is not an instance of MealTableViewCell.")
        }
        
        // Configure the cell...
        let item = self.items[indexPath.section][indexPath.row]
        
        cell.colorLabel.text = item.colorHex
        cell.temperatureLabel.text = "\(item.temperatureIndex!)"
        if let decodedData = Data(base64Encoded: item.imageBase64!, options: .ignoreUnknownCharacters) {
            cell.photo.image = UIImage(data: decodedData)
        }
        
        return cell
    }
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        
        super.prepare(for: segue, sender: sender)
        
        switch(segue.identifier ?? "") {
        case "AddItem":
            os_log("Adding a new item.", log: OSLog.default, type: .debug)
            
            
        case "ShowDetail":
            guard let itemDetailViewController = segue.destination as? ItemViewController else {
                fatalError("Unexpected destination: \(segue.destination)")
            }
            
            guard let selectedItemCell = sender as? ItemTableViewCell else {
                fatalError("Unexpected sender: \(String(describing: sender))")
            }
            
            guard let indexPath = tableView.indexPath(for: selectedItemCell) else {
                fatalError("The selected cell is not being displayed by the table")
            }
            
            let selectedItem = items[indexPath.section][indexPath.row]
            itemDetailViewController.item = selectedItem

        default:
            fatalError("Unexpected Segue Identifier; \(String(describing: segue.identifier))")
        }
    }
 
    // MARK: - Private Methods
    
    private func generateCategories(){
        let boots = Category(id: 0, category: "Boots")
        let coat = Category(id: 1, category: "Coat")
        let flipflop = Category(id: 2, category: "Flip Flop")
        let jacket = Category(id: 3, category: "Jacket")
        let shoes = Category(id: 4, category: "Shoes")
        let shorts = Category(id: 5, category: "Shorts")
        let sleeves = Category(id: 6, category: "Sleeves")
        let suit = Category(id: 7, category: "Suit")
        let sweater = Category(id: 8, category: "Sweater")
        let trouser = Category(id: 9, category: "Trousers")
        let tshirt = Category(id: 10, category: "T-Shirt")
        let vest = Category(id: 11, category: "Vest")

        categories = [boots, coat, flipflop, jacket, shoes, shorts, sleeves, suit, sweater, trouser, tshirt, vest]
        for _ in 1...categories.count{
            self.items.append([Item]())
        }
    }
    
    private func loadItems(){
        let itemService = ItemService()
        itemService.getAllItems(){
            (items) in
            // OFF THE MAIN QUEUE
            DispatchQueue.main.async {
                for item in items! {
                    self.items[item.categoryId!].append(item)
                }
                self.tableView.reloadData()
            }
        }
    }

}
