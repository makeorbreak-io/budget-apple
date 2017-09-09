//
//  ItemViewController.swift
//  PiDrobe
//
//  Created by Luis Goncalves on 09/09/2017.
//  Copyright © 2017 Budget Apple. All rights reserved.
//

import UIKit

class ItemViewController: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate {

    // MARK: - Properties
    @IBOutlet weak var photo: UIImageView!
    @IBOutlet weak var categoryField: UITextField!
    @IBOutlet weak var colorField: UITextField!
    @IBOutlet weak var heatSlider: UISlider!
    
    var item: Item?
    var categories: [Category]?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        // Set up views if editing an existing Item.
        if let item = item {
            navigationItem.title = "Item"
            if let decodedData = Data(base64Encoded: item.imageBase64!, options: .ignoreUnknownCharacters) {
                photo.image = UIImage(data: decodedData)
            }
            colorField.text = item.colorHex
            categoryField.text = categories?[item.categoryId!].category
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
        
        // Make sure ViewController is notified when the user picks an image.
        imagePickerController.delegate = self
        present(imagePickerController, animated: true, completion: nil)
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
