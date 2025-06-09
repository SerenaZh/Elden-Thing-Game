# FIT2099 Assignment (Semester 1, 2025)

```
`7MM"""YMM  `7MMF'      `7MM"""Yb. `7MM"""YMM  `7MN.   `7MF'    MMP""MM""YMM `7MMF'  `7MMF'`7MMF'`7MN.   `7MF' .g8"""bgd  
  MM    `7    MM          MM    `Yb. MM    `7    MMN.    M      P'   MM   `7   MM      MM    MM    MMN.    M .dP'     `M  
  MM   d      MM          MM     `Mb MM   d      M YMb   M           MM        MM      MM    MM    M YMb   M dM'       `  
  MMmmMM      MM          MM      MM MMmmMM      M  `MN. M           MM        MMmmmmmmMM    MM    M  `MN. M MM           
  MM   Y  ,   MM      ,   MM     ,MP MM   Y  ,   M   `MM.M           MM        MM      MM    MM    M   `MM.M MM.    `7MMF'
  MM     ,M   MM     ,M   MM    ,dP' MM     ,M   M     YMM           MM        MM      MM    MM    M     YMM `Mb.     MM  
.JMMmmmmMMM .JMMmmmmMMM .JMMmmmdP' .JMMmmmmMMM .JML.    YM         .JMML.    .JMML.  .JMML..JMML..JML.    YM   `"bmmmdPY  
```
Contributions log: https://docs.google.com/spreadsheets/d/1qlEmjwCmgAbjDdFvwbJjhd0uasW1hyAIcpXi7bx7z2s/edit?usp=sharing


Handover Videos:

Khushi Rajpurohit - https://drive.google.com/file/d/15arpZg7GfnLDCtajjbaDY3bdViHnn4FI/view?usp=sharing

Sandeesa Rajapaksa - Link to Zoom/Google Drive/Panopto/unlisted YouTube video

Mohammed Osamah A Almaharif - Link to Zoom/Google Drive/Panopto/unlisted YouTube video

Serena Zhou - https://drive.google.com/drive/folders/11Vqf97bm0pbGr-6IP_V0TurqJMSgJkqW?usp=sharing

Aryan Majidi Mobaraki - https://drive.google.com/file/d/1utVfyzKH_cTS5TUX2pFSq7sGwOefWvuf/view?usp=sharing



Creative requirements Plan:

Creative REQ 3

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
Req3 - Approved by Jordan May 28th 16:06

Creative REQ4 Video: https://drive.google.com/file/d/1utVfyzKH_cTS5TUX2pFSq7sGwOefWvuf/view?usp=sharing
Affection level/Factions system.
1) There will be an Affectionable interface with Actions (which act on NPCs which are part of a faction).
- For instance, the farmer can give items to the NPCs, which will increase their affection level towards the farmer.
- Each NPC faction type can be affected by different actions as well:
  - By doing good things, like planting trees, farmer can increase their standing with animal npc or hostile npc factions
  - By giving items farmer can increase their standing with merchants npc factions
  - By hitting CREATURE faction member with weapons, you can decrease your standing with them. 
2) There will need to be a Faction class (higher level class); a total of 3 Factions will extend this:
- Merchant faction
- Hostile faction
- Creature faction
Your standing with a faction can affect prices or behaviour.
- for example if your standing with the merchant faction is above 5, you get 50% price reduction for items
- if your standing with friendly animals is less than 5, they (the animal being hit) will avoid you (move away when you move close)
- conversely if your standing with the Hostile faction is high enough, they will be more likely to move away after attacking you