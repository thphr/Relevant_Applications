//
//  BulletJournalController.swift
//  iOS_Project
//
//  Created by Veena Balakumar on 20/10/2018.
//  Copyright © 2018 SDU. All rights reserved.
//

import UIKit

class BucketListController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet weak var input: UITextField!
    @IBOutlet weak var myTableView: UITableView!
    
    let entityName = "BucketList"
    
    
    var list: [String] = []
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return (list.count)
        
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell(style: UITableViewCell.CellStyle.default, reuseIdentifier: "cell")
        cell.textLabel?.text = list[indexPath.row]
        
        return (cell)
    }
    
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath)
    {
        if editingStyle == UITableViewCell.EditingStyle.delete
        {
            
            if let deleteValue = list[indexPath.row] as? String {
                coreData().deleteToDo(name: deleteValue, entityName: self.entityName)
                list.remove(at: indexPath.row)
                self.viewDidLoad()
            }
            
            myTableView.reloadData()
        }
    }
    
    @IBAction func addItemButton(_ sender: Any) {
        if(input.text != "")
        {
            
            coreData().SaveToDo(name: input.text!, entityName: self.entityName)
            self.viewDidLoad()
            input.text = ""
            input.resignFirstResponder()
            myTableView.reloadData()
        }
    }
    
    func addToList(array: [String]) -> Void{
        if array.count > 0 {
            for bucket in array {
                if !list.contains(bucket) {
                    list.append(bucket)
                }
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.addToList(array: coreData().loadToDo(entityName: self.entityName))
    }
    
    
}

