# City description

## Attributes
    String name
- Name of the city
- (has simple getter)
- (setter checks if not null)

&nbsp;

    int bushelCount
- How many bushels the city has (initially 2800)
- (Has simple getter)
- (Setter checks if >= 0)


&nbsp;

    int acreCount
- How many acres the city has
(initially 1000)
- (Has simple getter)
- (Setter checks if >= 0)

&nbsp;

    int population
- Population of the city
(ititially 100)
- (Has simple getter)
- (Setter checks if >= 0)

&nbsp;

    int age
- Age of the city in years
(starts at 0/1 ??)
- (Has simple getter)

&nbsp;

    int currentBushelSpendingOnFood
- How many bushels are to be spent on feeding the population
- (starts at 0?)
- (Has simple getter)
- ###(Setter checks if >=0 and <= `this.bushelCount`)
- No setter

&nbsp;

    int currentUsedAcreCount
- How many acres are used to harvest crops
- (starts at 0?)
- (Has simple getter)
- ###(Setter checks if >=0 and <= `this.bushelCount`)
- No setter

## Methods
    boolean buy(int acreCount, int acrePrice)
- Attempts to buy `acreCount` acres of land at `acrePrice` bushels per acre
- If enough bushels in stock:
    - increase `this.acreCount` by the corresponding amount
    - decrease `this.bushelCount` by `acrePrice` * `acreCount`
    - return `true`
- If not:
    - Make no changes to the city
    - Return `false`


&nbsp;

    boolean sell(int acreCount, int acrePrice)
- Attempts to buy `acreCount` acres of land at `acrePrice` bushels per acre
- If enough acres to be sold (`this.acreCount` >= `acreCount` >= 0):
    - decrease `this.acreCount` by the corresponding amount
    - increase `this.bushelCount` by `acrePrice` * `acreCount`
    - return `true`
- If not:
    - Make no changes to the city
    - Return `false`

&nbsp;

    boolean feed(int bushelCount)
- Attempts to feed `bushelCount` bushels to the population
- if enough bushels to be spent (`this.bushelCount` >= `bushelCount` >= 0):
    - decrease `this.bushelCount` by `bushelCount`
    - adjust the city's population depending on how they got fed
    - return `true`
- If not:
    - Make no changes to the city
    - Return `false`

&nbsp;

    boolean plant(int acreCount)
- Attempts to plant `acreCount` acresv
- Requirements to be met:
    - Having enough land to plant (`this.acreCount` >= `acreCount`)
    - Having enough bushels to plant (`this.bushelCount` >= `acreCount`)
    - Having enough population to plant (@ 10 acres / person) (`this.population` * 10 >= `acreCount`)
- If requirements are met:
    - decrease `this.bushelCount` by `acreCount`
    - return `true`
    - [TODO] add to current bushelCount?
- If not:
    - Make no changes to city
    - return `false`

&nbsp;

    String toString()
- Return the city's string representation
- "In the year [age] after its foundation, the city of [name] and its [population] inhabitants reign over [acreCount] acres of land and own [bushelCount] bushels of grain."


## Population curve
Requirements:
- if no food, everyone dead
- if just enough food, no change
- as food -> +inf, +10%

Want to use a curve with $f(x) = -\frac{1}{ax+b}+K$ with the following properties:
- It denotes the percentage of population change given how much food is given
- When $x = 0, f(x) = -1$
- When $x = population * 20, f(x) = 0$
- As $x \rightarrow +\infty, f(x) \rightarrow 0.10 $

It follows that $K = 0.10$.  
We also have $- \frac{1}{b}+K = -1$ --> $b = \frac{1}{K+1}$  

If the result is negative, then we then add the previous variation percentage to the result of the function to make the effects. If not, then just take the function result.







