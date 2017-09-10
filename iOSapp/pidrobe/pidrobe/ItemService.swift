//
//  ItemProcessor.swift
//  PiDrobe
//
//  Created by Luis Goncalves on 09/09/2017.
//  Copyright © 2017 Budget Apple. All rights reserved.
//

import Foundation

class ItemService
{
    let itemBaseUrl: URL?
    
    init() {
        itemBaseUrl = URL(string: "http://192.168.43.122:8080/rest/api/items")
    }
    
    //Gets All Items
    func getAllItems(completion: @escaping([Item]?) -> Void){
        var allItems = [Item]()
        
        let networkProcessor = NetworkProcessor(url: itemBaseUrl!)
        networkProcessor.downloadJSONArrayFromURL({ (jsonArray) in
            for jsonDictionary in jsonArray! {
                let item = Item(dictionary: jsonDictionary as! [String : Any])
                allItems.append(item)
            }
            completion(allItems)
        })
    }
    
    func postItem(item: Item){
        let url = URL(string: "\(itemBaseUrl!)/add")
        let networkProcessor = NetworkProcessor(url: url!)
        networkProcessor.postJSON(json: item.toJson())
        
    }
}
