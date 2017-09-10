//
//  ItemViewController.swift
//  PiDrobe
//
//  Created by Luis Goncalves on 09/09/2017.
//  Copyright © 2017 Budget Apple. All rights reserved.
//

import UIKit
import os.log

class ItemViewController: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate, UITextFieldDelegate, UIPickerViewDelegate, UIPickerViewDataSource, ChromaColorPickerDelegate {

    // MARK: - Properties
    @IBOutlet weak var photo: UIImageView!
    @IBOutlet weak var categoryField: UITextField!
    @IBOutlet weak var colorField: UITextField!
    @IBOutlet weak var heatSlider: UISlider!
    @IBOutlet weak var saveButton: UIBarButtonItem!
    @IBOutlet weak var categoryPicker: UIPickerView! = UIPickerView()
    @IBOutlet weak var colorPickView: UIView!
    
    var item: Item?
    var categories = ["Coat", "Flip Flop", "Jacket", "Shoes","Shorts", "Sleeves", "Suit", "Sweater", "Trousers", "T-Shirt", "Vest"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        categoryPicker.isHidden = true
        self.categoryField.delegate = self
        self.colorField.delegate = self
        self.categoryPicker.delegate = self
        self.categoryPicker.dataSource = self
    
        let neatColorPicker = ChromaColorPicker(frame: CGRect(x: 0, y: 0, width: 300, height: 300))
        neatColorPicker.center = CGPoint(x: colorPickView.bounds.size.width  / 2,y: colorPickView.bounds.size.height / 2);
        neatColorPicker.delegate = self //ChromaColorPickerDelegate
        neatColorPicker.padding = 8
        neatColorPicker.stroke = 8
        neatColorPicker.hexLabel.textColor = UIColor.black
        
        colorPickView.addSubview(neatColorPicker)
        
        // Do any additional setup after loading the view.
        
        // Set up views if editing an existing Item.
        if let item = item {
            navigationItem.title = "Item"
            if let decodedData = Data(base64Encoded: item.imageBase64!, options: .ignoreUnknownCharacters) {
                photo.image = UIImage(data: decodedData)
            }
            colorField.text = item.colorHex
            categoryField.text = categories[item.categoryId!]
            heatSlider.value = Float(item.temperatureIndex!)
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // MARK: - Actions
    @IBAction func editPhoto(_ sender: UITapGestureRecognizer) {
        
        // UIImagePickerController is a view controller that lets a user pick media from their photo library.
        let imagePickerController = UIImagePickerController()
        
        imagePickerController.sourceType = .camera

        
        // Make sure ViewController is notified when the user picks an image.
        imagePickerController.delegate = self
        present(imagePickerController, animated: true, completion: nil)
    }

    @IBAction func cancelClick(_ sender: UIBarButtonItem) {
        // Depending on style of presentation (modal or push presentation), this view controller needs to be dismissed in two different ways.
        let isPresentingInAddMealMode = presentingViewController is UINavigationController
        
        if isPresentingInAddMealMode {
            dismiss(animated: true, completion: nil)
        }
        else if let owningNavigationController = navigationController{
            owningNavigationController.popViewController(animated: true)
        }
        else {
            fatalError("The MealViewController is not inside a navigation controller.")
        }
    }
    
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        super.prepare(for: segue, sender: sender)
        
        // Configure the destination view controller only when the save button is pressed.
        guard let button = sender as? UIBarButtonItem, button === saveButton else {
            os_log("The save button was not pressed, cancelling", log: OSLog.default, type: .debug)
            return
        }
        
        //TODO add catergory ID
        var categoryID : Int
        
        for category in categories{
            if(category == categoryField.text){
                categoryID = categories.index(of: category)!
                
                let photoBase64 = UIImagePNGRepresentation(photo.image!)?.base64EncodedString(options: .lineLength64Characters)
                let temperatureIndex = Int(heatSlider.value)
                let color = colorField.text
                
                // Set the meal to be passed to MealTableViewController after the unwind segue.
                item = Item(id: 0, categoryId: categoryID, colorHex: color!, temperatureIndex: temperatureIndex, imageBase64: photoBase64!, isAvailable: true)
            }
        }
        
    }
    
    // MARK: - Text field and Picker delegate and Data Source
    
    // returns the number of 'columns' to display.
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    // returns the # of rows in each component..
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int{
        return categories.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return categories[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int)
    {
        self.categoryField.text = self.categories[row]
        categoryPicker.isHidden = true
    }
    
    func textFieldShouldBeginEditing(_ textField: UITextField) -> Bool {
        if(textField == self.categoryField){
            categoryPicker.isHidden = false
        }
        
        if(textField == self.colorField){
            colorPickView.isHidden = false
        }
        return false

    }
    
    // MARK: - Color Picker Delegate
    func colorPickerDidChooseColor(_ colorPicker: ChromaColorPicker, color: UIColor){
        self.colorField.text = color.hexCode
        colorPickView.isHidden = true
    }


}
