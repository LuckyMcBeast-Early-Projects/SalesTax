  _  _____       _          _____            _  
 | |/  ___|     | |        |_   _|          | | 
/ __) `--.  __ _| | ___  ___ | | __ ___  __/ __)
\__ \`--. \/ _` | |/ _ \/ __|| |/ _` \ \/ /\__ \
(   /\__/ / (_| | |  __/\__ \| | (_| |>  < (   /
 |_|\____/ \__,_|_|\___||___/\_/\__,_/_/\_\ |_| 
                                                
  _____        ___             _______        ____                 
 / ___/__  ___/ (_)__  ___ _  / ___/ /  ___ _/ / /__ ___  ___ ____ 
/ /__/ _ \/ _  / / _ \/ _ `/ / /__/ _ \/ _ `/ / / -_) _ \/ _ `/ -_)
\___/\___/\_,_/_/_//_/\_, /  \___/_//_/\_,_/_/_/\__/_//_/\_, /\__/ 
                     /___/                              /___/      


(----READ ME----)

This application calculates sales tax for a group of items, which is
known as a cart, and returns an itemized receipt with amount tax and total.
The program operates under the following provided rules:

Basic sales tax is applicable at a rate of 10% on all goods, except books, food,
and medical products that are exempt. Import duty is an additional sales tax applicable 
on all imported goods at a rate of 5%, with no exemptions.
 
When I purchase items I receive a receipt which lists the name of all the items and 
their price (including tax), finishing with the total cost of the items, and the total 
amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, 
a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

(Items and their Carts)

All items have the following attributes:

Quantity - an integer for the amount of the item (Negatives are allowed and considered a "return/exchange")
Name - the name of the item
Price - the cost of the item (Ex: 0.00)
Taxable? - whether or not tax is applicable (Either true or false)
Imported? - whether or not the item is imported (Also true or false)

These items are held in carts that can contain any number of items. These carts are
stored in cart data files.

(Menu Options)

To select an option on the menu press the associated number followed by ENTER

1. Process Cart From File:
This option selects a cart file from the cart directory and processes that
cart.

2. Generate New Cart File:
Acts as a cart file generation wizard that make a cart file for you with the associated items.
Note that if you enter the data incorrectly, the program will not process your new cart file.

3. Display Cart Directory Contents:
As the name implies, it shows the contents of the cart directory that can be used to execute
option 1.

(Cart Formatting Instructions)

Provide source Cart files with the following format:
        
	Quantity(int),Name,Price(double),Taxable?(true/false),Imported?(true/false),
	
	Example: 1,Imported Book,14.25,false,true,

Though the file does not have to be a txt file, .txt and .csv files are 
preferred and have been tested.

IMPORTANT NOTE: Do NOT use Microsoft Excel to edit or create .csv cart files. The last 
comma on each line will not be populated with default settings, causing the data to be 
read incorrectly. If you use spreadsheet software to edit or create these files, make 
sure you can configure the CSV formatting to match the formatting above. OpenOffice Calc 
has this option by default and is free and open source.
	
Cart files should be saved in the the carts directory in src.
	
The program has a Cart file generator, as well. Simply enter option 2 from the Menu 
and follow the instructions.
