//
//  ToDoController.swift
//  iOS_Project
//
//  Created by Veena Balakumar on 20/10/2018.
//  Copyright © 2018 SDU. All rights reserved.
//

import UIKit
import CoreData
import Foundation

class ToDoController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet weak var input: UITextField!
    @IBOutlet weak var myTableView: UITableView!
    
    let entityName = "Todos"
    var todos: [String] = []
    
    //Number of rows in tableview
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return (todos.count)
        
    }
    //What to display at each cell in tableview
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = UITableViewCell(style: UITableViewCell.CellStyle.default, reuseIdentifier: "cell")
        cell.textLabel?.text = todos[indexPath.row]
        
        return cell
    }
    
    //delete task functionality
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath)
    {
        if editingStyle == UITableViewCell.EditingStyle.delete
        {
            
            //deletes the selected tasks form the todolist and the core data
            if let deleteValue = todos[indexPath.row] as? String {
                coreData().deleteToDo(name: deleteValue, entityName: self.entityName)
                todos.remove(at: indexPath.row)
                self.viewDidLoad()
            }
            
            myTableView.reloadData()
        }
    }
    //Adding task to list and core data and loading to tableview:
    @IBAction func addItemButton(_ sender: Any) {
        if(input.text != "")
        {
            //saves the added todo/ task to the core data
            coreData().SaveToDo(name: input.text!, entityName: self.entityName)
            
            //runs the viewDidLoad method to refresh the todolist with the added task
            self.viewDidLoad()
            
            input.text = ""
            input.resignFirstResponder()
            myTableView.reloadData()
        }
    }
    
    //The method adds the value of an array to an existing array
    func addToList(array: [String]) -> Void{
        if array.count > 0 {
            for todo in array {
                if !todos.contains(todo) {
                    todos.append(todo)
                }
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //adds image array from the core data to the todolist
        self.addToList(array: coreData().loadToDo(entityName: self.entityName))
        
    }
    
}
