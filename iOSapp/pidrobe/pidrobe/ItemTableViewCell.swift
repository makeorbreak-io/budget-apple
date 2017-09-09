//
//  ItemTableViewCell.swift
//  PiDrobe
//
//  Created by Luis Goncalves on 09/09/2017.
//  Copyright © 2017 Budget Apple. All rights reserved.
//

import UIKit

class ItemTableViewCell: UITableViewCell {
    
    // MARK: - Properties
    @IBOutlet weak var photo: UIImageView!
    @IBOutlet weak var colorLabel: UILabel!
    @IBOutlet weak var temperatureLabel: UILabel!

    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
