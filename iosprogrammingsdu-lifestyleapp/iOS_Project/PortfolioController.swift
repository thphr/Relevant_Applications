//
//  PortfolioController.swift
//  iOS_Project
//
//  Created by Veena Balakumar on 26/11/2018.
//  Copyright © 2018 SDU. All rights reserved.
//

import UIKit
import Foundation

class PortfolioController: UIViewController, UICollectionViewDataSource, UICollectionViewDelegate {
    
    var images: [UIImage]!
    
    

    @IBOutlet var collectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //Loads the stored images from core data
        images = coreData().loadImage()
        
        //reloads the data in the collectionView
        collectionView.reloadData()
        
        collectionView.dataSource = self
        collectionView.delegate = self

    }
    
    
    //Numbers of items is equal the number of images loaded from the core data
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        
        return images.count
    }
    
    
    //sets imageView in each sell the be the corresponding image from the array of images
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "collectionCell", for: indexPath) as! photoCell
        
        let photo = images[indexPath.row] 
        
        cell.backgroundColor = UIColor.white
        
        cell.imageView.image = photo
        
        return cell
        
    }
    

    
    
    

    
    
    
    
}
