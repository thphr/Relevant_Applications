//
//  HabitController.swift
//  iOS_Project
//
//  Created by Veena Balakumar on 27/11/2018.
//  Copyright © 2018 SDU. All rights reserved.
//

import Foundation

import UIKit

var listOfHabits = [Habit]()
var habitDes = ["bla bla bla", "heh.."]
var myIndex = 0


class HabitController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet weak var titleOfHabit: UITextField!
    @IBOutlet weak var daysOfHabits: UITextField!
    @IBOutlet weak var myTableView: UITableView!
    
    //The rows in the section equals to the array list: list of Habits
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return (listOfHabits.count)
        
    }
    
    // Display content in the cell
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell(style: UITableViewCell.CellStyle.default, reuseIdentifier: "cell")
        cell.textLabel?.text = listOfHabits[indexPath.row].habitTitle
        
        //This will allow to show longer sentences and contents in the cell
        cell.textLabel?.numberOfLines = 0
        return (cell)
    }
    
    //When deleting a cell/a habit
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath)
    {
        if editingStyle == UITableViewCell.EditingStyle.delete
        {
            listOfHabits.remove(at: indexPath.row)
            myTableView.reloadData()
        }
    }
    
    //When selecting a habit you will be navigated to a new view
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        myIndex = indexPath.row
        performSegue(withIdentifier: "segue", sender: self)
    }
    
    //When clicking the add button: creating an object habit and added the title and daysOfHabits to the object and then make sure the fields are empty again
    @IBAction func addItemButton(_ sender: UIButton) {
        
        if(titleOfHabit.text != "" && daysOfHabits.text != "")
        {
            var newHabit = Habit()
            newHabit.habitTitle = titleOfHabit.text!
            newHabit.daysOfHabit = Int(daysOfHabits.text!)!
            listOfHabits.append(newHabit)
            titleOfHabit.text = ""
            titleOfHabit.resignFirstResponder()
            daysOfHabits.resignFirstResponder()
            myTableView.reloadData()
            
        } else {
            //Using alert if the user has not filled in the two fields 
            let alertController = UIAlertController(title: "Error", message: "Please fill in the fields", preferredStyle: UIAlertController.Style.alert)
            alertController.addAction(UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: nil))
            present(alertController, animated: true, completion: nil)
            
        }
        
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        myTableView.estimatedRowHeight =  44
        myTableView.rowHeight = UITableView.automaticDimension
        print(listOfHabits)
    }
    
}
