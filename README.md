Elden Thing Game

```
`7MM"""YMM  `7MMF'      `7MM"""Yb. `7MM"""YMM  `7MN.   `7MF'    MMP""MM""YMM `7MMF'  `7MMF'`7MMF'`7MN.   `7MF' .g8"""bgd  
  MM    `7    MM          MM    `Yb. MM    `7    MMN.    M      P'   MM   `7   MM      MM    MM    MMN.    M .dP'     `M  
  MM   d      MM          MM     `Mb MM   d      M YMb   M           MM        MM      MM    MM    M YMb   M dM'       `  
  MMmmMM      MM          MM      MM MMmmMM      M  `MN. M           MM        MMmmmmmmMM    MM    M  `MN. M MM           
  MM   Y  ,   MM      ,   MM     ,MP MM   Y  ,   M   `MM.M           MM        MM      MM    MM    M   `MM.M MM.    `7MMF'
  MM     ,M   MM     ,M   MM    ,dP' MM     ,M   M     YMM           MM        MM      MM    MM    M     YMM `Mb.     MM  
.JMMmmmmMMM .JMMmmmmMMM .JMMmmmdP' .JMMmmmmMMM .JML.    YM         .JMML.    .JMML.  .JMML..JMML..JML.    YM   `"bmmmdPY  
```

This game is made by me and a 4 other teammates. When I organised our tasks, I organised it so that each person had to implement a separate aspect of the game.
While navigating organisational challenges I implemented a farming system for the game as detailed below in the Creative requirements section as well as many other features,
The base code was made using the code I wrote in the beginning and others contributed to different game mechanics moving forward. All contributions are documented in each file. 
Implementing this game gave me knowledge in SOLID principles as well as all the necessary OOP knowledge I needed, including drawing up UML diagrams and sequence diagrams. 

This is a 2d terminal-based game made inspired by a popular video game Elden Ring

How to play:
Use the num pad in order to move in the terminal:
8 = North, 6 = East, 4 = West, 2 = South, 9 = North East, 7 = North West, 3 = South East, 1 = South West
In this game there are interactable tiles if you stand on top of it, items to pick up and area effects. The goal is to defeat any bad creatures and upgrade your weapons!

Creative requirements Plan:

New Farming System
Inspiration: Realistic farming system. For instance, plants need to be watered, grounds can be shovelled, etc.

New plants!
- Daisy (New low level class)
- Lilac (New low level class)

Shovelling system:
In order to plant a seed, you need to first shovel the plantable soil
Shovelling may be done with a shovel
After digging you may plant a seed, which will turn into the plant

Implementation:
In order to implement this I will create a ShovelAction that will turn plantable soil into a hole. ← The ground Hole 
will be assigned capability TILLED (that it can accept seeds)

The ShovelAction will take a plantable ground as an attribute and then change that to a Hole later.
This allows us to adhere to SOLID principles
Single responsibility, the class only handles the act of Shovelling plantable ground
Interface Segregation, using Plantable as the only thing that can dig holes on

Alternatively you would need to use an instance of which breaks the Open/Closed principle as well as the Liskov 
Substitution principle.

Watering System:
Some plants will need to be watered every few turns, if not watered they will die
Watering can be done with a watering can that the farmer can use

Implementation:
In order to implement this, I will create a WaterAction that will reset a Thirsty plant (A plant that needs to be 
watered every X turns). Thirsty interface will have a method to reset the timer of the plant. If the timer ever 
reaches 0, the plant dies.

The WaterAction will add a Thirsty plant as its attribute and watering it will give the farmer 100 runes as well as 
resetting the timer of the plant.
This allows us to adhere to SOLID principles
Single responsibility, the class only handles the act of Watering Thirsty things
Interface Segregation, using Thirsty as the only thing that can be watered

Alternatively you would need to use an instance of which breaks the Open/Closed principle as well as the Liskov 
Substitution principle.

Pest System:
Caterpillars roam the world (New low level class)
When they encounter a plant that they can eat, they will eat it!
If a caterpillar manages to eat a plant, they will turn into a Aeonian Butterfly that can attack the Farmer

Implementation:
Caterpillar will be an NPA that can go around the world. The caterpillar has a ConsumeBehaviour. 
There will be a ConsumeAction/EatAction (OR maybe just a TransformAction, also Transform action will take an Interface 
Transformable or something) where once the caterpillar eats a Consumable plant, then the caterpillar will turn into the 
Butterfly. The action will take in the caterpillar, the plant and then get rid of them afterwards and leave in their 
place the Butterfly.

Alternatively you would need to use an instance of which breaks the Open/Closed principle as well as the Liskov 
Substitution principle.

