## Burrito_King
Advance Programming Assignment1

# ManageRestaurant Class:
  The constructor creates instance of Kitchen and Sale, and initializes a Food list.
  The main program loops through restaurant managing options of:
  * Order food
    - Creates instance of Order and prompt users to add food and quantity to the Order. 
    - Displays the total cost of the order and handles the payment. 
    - Displays prepare time from kitchen.
    - Add the order into the sales report.
  * Printing sales report
    - Displays remain unsold fries from kitchen.
    - Displays total sold food items and quantity from Sale, and calculates the total revenue. 
  * Update the price of food items
    - Prompt users to select food item and pass the input update price to the food.

# Food Class: 
  An abstract class that represents a type of food item with name and price as constructor parameters.
  Contains a method that updates the price to the taken argument value. 

# Burrito/ Fries/ Soda Class: 
  Subclasses of Food class that represents a specific type of food item.

# Order Class:
  Represents a order of food items and quantity using a HashMap. 
  Main functions: 
  - Adding food items to the order and accumulates the quantities of the same food item.
  - Keeping track of the number of meals in the order.
  - Printing and calculating the total cost of the order.
 
# Kitchen Class: 
  Responsible of: 
  - Calculating the preparation time for the order that is passed to the kitchen.
  - Keeping track of the unsold fries in the kitchen.

# Sale Class:
  Represents all the sold food items and quantities of the restaurant using a HashMap.
  Main functions:
  - Adding food items to the sales and accumulates the quantities of the same food item.
  - Keeping track of the total count of meals sold.

# JUnit TestOrder:
  Test the calculation of total cost for the order.

# JUnit TestKitchen:
  Test the calculation of order prepare time and final quantity of unsold fries.


# Link to Demo video
https://rmiteduau-my.sharepoint.com/:v:/r/personal/s3846375_student_rmit_edu_au/Documents/Recording-20240415_205756.webm?csf=1&web=1&e=32sisC