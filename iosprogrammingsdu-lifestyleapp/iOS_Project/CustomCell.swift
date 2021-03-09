//
//  CustomCell.swift
//  iOS_Project
//
//  Created by Veena Balakumar on 13/11/2018.
//  Copyright © 2018 SDU. All rights reserved.
//

import UIKit
import JTAppleCalendar

//Cell for calendar in general: gratitude calendar and moodtracker calendar
class CustomCell: JTAppleCell {
    
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var greenMarker: UIView!
    
    
    // Mood tracker
    @IBOutlet weak var redMarker: UIView!
    var goodDay = false
    var badDay = false
    var blankDay = true
    
    //Gratitude 
    var gratitude1 = ""
    var gratitude2 = ""
    var gratitude3 = ""
    
}

