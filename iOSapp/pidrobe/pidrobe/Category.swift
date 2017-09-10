//
//  Category.swift
//  PiDrobe
//
//  Created by Luis Goncalves on 09/09/2017.
//  Copyright © 2017 Budget Apple. All rights reserved.
//

import Foundation

class Category: NSObject{
    
    // MARK: - Properties
    var id: Int
    var category: String
    
    // MARK: - Initialization
    init(id: Int, category: String){
        self.id = id
        self.category = category
    }
    
}
