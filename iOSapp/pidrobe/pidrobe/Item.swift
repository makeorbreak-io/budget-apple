//
//  Item.swift
//  PiDrobe
//
//  Created by Luis Goncalves on 09/09/2017.
//  Copyright © 2017 Budget Apple. All rights reserved.
//

import Foundation
import UIKit

class Item: NSObject{
    
    // MARK: - Properties
    var id: Int?
    var categoryId: Int?
    var colorHex: String?
    var temperatureIndex: Int?
    var imageBase64: String?
    var isAvailable: Bool?
    
    // MARK: - Keys
    struct Keys{
        static let id = "id"
        static let categoryId = "category"
        static let colorHex = "color_hexa"
        static let imageBase64 = "image"
        static let temperatureIndex = "temperature_index"
        static let isAvailable = "available"
    }
    
    // MARK: - Initialization
    init(id: Int, categoryId: Int, colorHex: String, temperatureIndex: Int, imageBase64: String, isAvailable: Bool){
        self.id = id
        self.categoryId = categoryId
        self.colorHex = colorHex
        self.temperatureIndex = temperatureIndex
        self.imageBase64 = imageBase64
        self.isAvailable = isAvailable
    }
    
    init(dictionary: [String:Any]){
        self.id = dictionary[Keys.id] as? Int
        self.categoryId = dictionary[Keys.categoryId] as? Int
        self.colorHex = dictionary[Keys.colorHex] as? String
        self.temperatureIndex = dictionary[Keys.temperatureIndex] as? Int
        self.imageBase64 = dictionary[Keys.imageBase64] as? String
        self.isAvailable = dictionary[Keys.isAvailable] as? Bool
    }
}
