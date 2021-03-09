//
//  coreData.swift
//  iOS_Project
//
//  Created by Veena Balakumar on 21/11/2018.
//  Copyright © 2018 SDU. All rights reserved.
//

import Foundation
import UIKit
import CoreData

class coreData {
    
    //Defined to manage an object
    let context: NSManagedObjectContext
    
    init() {
        
        //sets the delegate to shared
        let appDelegate = UIApplication.shared.delegate as? AppDelegate
        
        //gets the persistence container to manage the core data stack
        self.context = appDelegate!.persistentContainer.viewContext
    }
    
    //Saves an image to the coredata model
    func saveImage(image: UIImage) {
        
        //defines date if wishes to sort the images
        let date : Double = NSDate().timeIntervalSince1970
        
        //converts the image to a png file
        let imageData = image.pngData()
        
        //gets an object defined in the core data model
        let entity = NSEntityDescription.entity(forEntityName: "Photo", in: self.context)
        
        //converts it to NSManagedObject
        let entityObj = NSManagedObject(entity: entity!, insertInto: self.context)
        
        //sets the value of the attributes of the object
        entityObj.setValue(imageData, forKey: "image")
        entityObj.setValue(date, forKey: "id")
        
        
        
        do{
            //save the changes of the object
            try self.context.save()
            
        }catch {
            fatalError("fail to save image!")
            
        }
        
    }
    
    //The method loads images from the core data model
    func loadImage() -> [UIImage] {
        
        var images: [UIImage] = []
        
        //makes a request to the persistence layer
        let fetchImage = NSFetchRequest<NSFetchRequestResult>(entityName: "Photo")
        
        do{
            
            //fetches the objects that meets the defined critaria
            let results = try self.context.fetch(fetchImage)
            
            //loops the results of it contains something
            if results.count > 0 {
                
                for result in results as! [NSManagedObject] {
                    
                    //gets an image
                    if let imageData = result.value(forKey: "image") as? Data {
                        if let image = UIImage(data: imageData){
                            
                            //adds it to the array of images
                            images.append(image)
                        }
                    }
                }
            }
            
            
        }catch{
            
            print("could not fetch image: ")
        }
        
        //returns an array of images retrieved from core data
        return images
    }
    
    
    //The method saves todolist and bucketlist
    func SaveToDo(name: String, entityName: String) {
        
        let entity = NSEntityDescription.entity(forEntityName: entityName, in: coreData().context)!
        
        let todo = NSManagedObject(entity: entity, insertInto: self.context)
        
        todo.setValue(name, forKey: "name")
        
        do{
            try self.context.save()
            
        }catch let error as NSError {
            print("could not save. \(error), \(error.userInfo)")
        }
    }
    
    
    //The method loads todolist and bucketlist from the persistence layer
    func loadToDo(entityName: String) -> [String] {
        
        var list: [String] = []
        
        let fetchRequest = NSFetchRequest<NSManagedObject>(entityName: entityName)
        
        do{
            
            let results = try self.context.fetch(fetchRequest)
            
            if(results.count > 0) {
                for result in results as [NSManagedObject] {
                    
                    if let todo = result.value(forKey: "name") as? String {
                        
                        list.append(todo)
                    }
                }
            }
            
        }catch let error as NSError {
            print("could not save. \(error), \(error.userInfo)")
        }
        
        return list
    }
    
    
    //The method deletes the todo and the bucket from the persistence layer
    func deleteToDo(name: String, entityName: String) {
        
        let fetchRequest = NSFetchRequest<NSManagedObject>(entityName: entityName)
        
        do{
            let results = try self.context.fetch(fetchRequest)
            
            if(results.count > 0) {
                for result in results as [NSManagedObject] {
                    
                    let todo = result.value(forKey: "name") as? String
                    
                    if todo==name {
                        
                        self.context.delete(result)
                    }
                }
            }
            
            try self.context.save()
            
        }catch let error as NSError {
            print("could not save. \(error), \(error.userInfo)")
        }
        
    }
    
    
    
    
}
