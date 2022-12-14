# Trabalho de POO 2022
Grupo 11

T5 – Agência de aluguer de automóveis

## Classes, Atributos e Métodos
### RentalAgency
- Atributos
  - name
  - branches
- Métodos
  - getters e setters
  - equals e clone
  - toString
  - addBranch, deleteBranch e findBranch
  - addCustomer, deleteCustomer e findCustomer
  - addCar, deleteCar e findCar
  - addCustomerTransaction
  - listCustomers

### Branch
- Atributos
  - name
  - customers
- Métodos
  - getters e setters
  - equals e clone
  - toString
  - newCustomer e findCustomer
  - addCustomerTransaction
  
### Customer
- Atributos
  - name
  - transactions
  - balances
  - initialBalance
  - cars
- Métodos
  - getters e setters
  - equals e clone
  - toString
  - addTransaction
  - transactionSum
  - currentBalance
  - newCar e findCar

### Car
- Atributos
  - name
  - pricePerDay
  - isRented
- Métodos
  - getters e setters
  - equals e clone
  - toString
  - rentCar

### FuncBranch
- Métodos
  - insertBranch e deleteBranch
  - insertCustomer e deleteCustomer
  - insertCar e deleteCar
  - updateFile

### Menu
- Métodos
  - menu
  - secondMenu

### Stats
- Métodos
  - menu

**README por acabar**
