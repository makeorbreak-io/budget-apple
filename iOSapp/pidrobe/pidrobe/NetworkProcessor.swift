//
//  Network Processor.swift
//  PiDrobe
//
//  Created by Luis Goncalves on 09/09/2017.
//  Copyright © 2017 Budget Apple. All rights reserved.
//

import Foundation

class NetworkProcessor
{
    lazy var configuration: URLSessionConfiguration = URLSessionConfiguration.default
    lazy var session: URLSession = URLSession(configuration: self.configuration)
    
    let url: URL
    
    init(url: URL)
    {
        self.url = url
    }
    
    typealias JSONDictionaryHandler = (([String : Any]?) -> Void)
    typealias JSONArrayHandler = (([Any]?) -> Void)
    
    func downloadJSONFromURL(_ completion: @escaping JSONDictionaryHandler)
    {
        let request = URLRequest(url: self.url)
        let dataTask = session.dataTask(with: request) { (data, response, error) in
            
            if error == nil {
                
                if let httpResponse = response as? HTTPURLResponse {
                    switch httpResponse.statusCode {
                    case 200:
                        // successful response
                        if let data = data {
                            do {
                                let jsonResponse = try JSONSerialization.jsonObject(with: data, options: [])
                                
                                if let dictionary = jsonResponse as? [String:Any]{
                                    completion(dictionary)
                                }
                                
                            } catch let error as NSError {
                                print("Error processing json data: \(error.localizedDescription)")
                            }
                            
                        }
                        
                    default:
                        print("HTTP Reponse Code: \(httpResponse.statusCode)")
                    }
                }
                
            } else {
                print("Error: \(String(describing: error?.localizedDescription))")
            }
        }
        
        dataTask.resume()
    }
    
    
    func downloadJSONArrayFromURL(_ completion: @escaping JSONArrayHandler)
    {
        let request = URLRequest(url: self.url)
        let dataTask = session.dataTask(with: request) { (data, response, error) in
            
            if error == nil {
                
                if let httpResponse = response as? HTTPURLResponse {
                    switch httpResponse.statusCode {
                    case 200:
                        // successful response
                        if let data = data {
                            do {
                                let jsonResponse = try JSONSerialization.jsonObject(with: data, options: [])
                                
                                if let array = jsonResponse as? [Any] {
                                    completion(array)
                                }
                                
                            } catch let error as NSError {
                                print("Error processing json data: \(error.localizedDescription)")
                            }
                            
                        }
                        
                    default:
                        print("HTTP Reponse Code: \(httpResponse.statusCode)")
                    }
                }
                
            } else {
                print("Error: \(String(describing: error?.localizedDescription))")
            }
        }
        
        dataTask.resume()
    }
    
    func postJSON(body: String){
        var request = URLRequest(url: self.url)
        request.httpMethod = "POST"
        let postString = body
        request.httpBody = postString.data(using: .utf8)
        let task = URLSession.shared.dataTask(with: request) { data, response, error in
            guard let data = data, error == nil else {                                                 // check for fundamental networking error
                print("error=\(String(describing: error))")
                return
            }
            
            if let httpStatus = response as? HTTPURLResponse, httpStatus.statusCode != 200 {           // check for http errors
                print("statusCode should be 200, but is \(httpStatus.statusCode)")
                print("response = \(String(describing: response))")
            }
            
            let responseString = String(data: data, encoding: .utf8)
            print("responseString = \(String(describing: responseString))")
        }
        task.resume()
    }
}
