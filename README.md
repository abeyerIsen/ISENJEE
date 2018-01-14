# Practice 02

## Intro

With this practical work, just a few things:
* Build a new Maven project
* Implement all the necessary classes without modifying the tests, they should pass at the end of this work.
* You will understand the main concept of IoC with a simple app.

## Context

* Two customers : Mrs Michu & the "AwesomePros" company
* Two shops : The Apple Store & The Knowledge Store
* Each customer has a favourite shop
* Each shop has a stock of products
* The customers are able to send orders to the shops, because they can buy new products! 


## Details

### The customers
* Mrs Michu and AwesomePros are both customers but the company has a one more specific field : a license number.
* We will declare an interface `Customer` and two implementations : `Person` and `Company`
* The `Company` class has a `license` string field.
* Both implementations has a `favouriteShop` field of type `Shop`
* The `Customer` interface contains a `sendOrder` method that return nothing but consumes an order.
* If you call the `sendOrder` method of a `Person`, it calls the `updateStocks` of the `favouriteShop`.
* If you call the `sendOrder` method of a `Company`, it adds the license number to the order then updates the stock of the favourite shop.

### The shops
* The Apple Store and the Knowledge Store are instances of the `Shop` interface.
* Two methods for this interface:
  * `updateStocks(Order order)`
  * `getStock()`  
* The Apple Store is the favourite shop of Mrs Michu whereas The Knowledge Store is the favourite of the "AwesomePros" company.
* The stock of a shop is just a `Map` that associates a `String` and an `Integer`

## The Order
* Just a POJO that holds a optionnal license and a list of `String` that represents the products.

### Beans
* Four beans should be declared in the `AppConfig` class:
  * `appleStore`
  * `knowledgeStore`
  * `mrsMichu`
  * `awesomePros`

## "One more think"
* Why do we have only one implementation of `Shop` but two of `Customer`?
* Why the `favouriteShop` attribute is not of type `ShopImpl`?
  * Would it work?
* What if the "AwesomePros" company want to order in several shops? Suggest a solution (but it is too easy to only change the favourite shop of the Customer ;) )
   