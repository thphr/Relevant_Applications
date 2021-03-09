//
//  CameraController.swift
//  iOS_Project
//
//  Created by Veena Balakumar on 16/10/2018.
//  Copyright © 2018 SDU. All rights reserved.
//

import UIKit

class CameraController: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate {
    
    
    var imagePickerController : UIImagePickerController! {
        didSet{
            imagePickerController = UIImagePickerController()
        }
    }
    
    @IBOutlet weak var imageView: UIImageView!
    
    
    //The method checks if the camera is avaiable else the function is disable
    @IBOutlet weak var takePhoto: UIButton!{
        didSet{
            takePhoto.isEnabled = UIImagePickerController.isSourceTypeAvailable(.camera)
        }
    }
    
    //The method checks if the photolibrary is avaiable else the function is disable
    @IBOutlet weak var selectPhoto: UIButton!{
        didSet{
            selectPhoto.isEnabled = UIImagePickerController.isSourceTypeAvailable(.photoLibrary)
        }
    }
    
    //The method displays the camera when the user wants to take a picture
    @IBAction func takePhoto(_ sender: UIButton) {
        imagePickerController = UIImagePickerController()
        imagePickerController.delegate = self
        imagePickerController.sourceType = .camera
        
        imagePickerController.allowsEditing = true
        
        //presents the camera
        present(imagePickerController, animated: true ,completion: nil)
    }
    
    //The method displays the photolibrary when the user wants to select a photo from it
    @IBAction func selectPhoto(_ sender: UIButton) {
        
        imagePickerController = UIImagePickerController()
        imagePickerController.sourceType = .photoLibrary
        imagePickerController.allowsEditing = true
        imagePickerController.delegate = self
        
        //presents the photolibrary
        present(imagePickerController, animated: true, completion: nil)
    }
    
    
    //Method is triggered when the user cancels the camera or photolibrary
    func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
        
        //dismiss the camera or the library
        picker.dismiss(animated: true, completion: nil)
    }
    
    
    //Method is triggered when the user has picked an image they want to use
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
        
        //gets the picked image and sets it as an UIImage
        if let image = (info[UIImagePickerController.InfoKey.editedImage] ?? info[UIImagePickerController.InfoKey.originalImage]) as? UIImage {
            
            //sets the picked image to the imageView (displays the image picked)
            self.imageView.image = image
            
            //saves the picked image to the persistence layer
            coreData().saveImage(image: image)
            
            
        }
        
        //dismisses the camera or the library after an image has been picked
        picker.dismiss(animated: true, completion: nil)
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
    }
    
    
}
