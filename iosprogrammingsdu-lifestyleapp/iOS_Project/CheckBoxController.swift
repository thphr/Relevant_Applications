//
//  CheckBoxController.swift
//  iOS_Project
//
//  Created by Veena Balakumar on 27/11/2018.
//  Copyright © 2018 SDU. All rights reserved.
//

import UIKit

class CheckBoxController: UIViewController, UICollectionViewDataSource, UICollectionViewDelegate{
    
    @IBOutlet weak var habitTitle: UILabel!
    
    var listOfCheckBoxes: [String] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let titleOfHabit = listOfHabits[myIndex].habitTitle
        let numberOfDays = listOfHabits[myIndex].daysOfHabit
        habitTitle.text = titleOfHabit
        
        for i in 0..<numberOfDays {
            let image = "checkBoxOUTLINE @2x"
            listOfCheckBoxes.append(image)
        }
        
    }
    
    //Number of views in collection view - Creating the views
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return listOfCheckBoxes.count
    }
    
    //Populate the views with the image
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        //accessing the imageview from the myCell class
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "cell", for: indexPath) as! myCell
        
        cell.myImageView.image = UIImage(named: listOfCheckBoxes[indexPath.row] + ".png")
        return cell
    }
    
    
    //If the checkboxes are selected the image have to change
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        
        let cell = collectionView.cellForItem(at: indexPath) as! myCell
        
        if cell.isSelected {
            
            if cell.isCheckBoxSelected == false {
                cell.isCheckBoxSelected = true
                cell.myImageView.image = UIImage(named:"checkBoxFILLED @2x" + ".png")
                
                
            } else if cell.isCheckBoxSelected == true {
                cell.myImageView.image = UIImage(named:"checkBoxOUTLINE @2x" + ".png")
                cell.isCheckBoxSelected = false
            }
        }
        
        //print("Is checbox selected?", cell.isCheckBoxSelected)
        
    }
}

