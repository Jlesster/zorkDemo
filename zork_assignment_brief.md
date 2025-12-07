
---

### 1. zorkPlayer Class

Create a class called `zorkPlayer` that stores information about the player character.

#### Instance Variables

- `String pName` – the player's character name.
- `String pClass` – the player's chosen class (e.g., "Ranger", "Fighter", "Mage").
- `double health` – the player's current health points.
- `double maxHealth` – the player's maximum health capacity.
- `double damage` – the player's attack damage value.
- `double xp` – the player's current experience points.
- `double xpToLevel` – experience points required to reach the next level.
- `int level` – the player's current level.

#### Constructor:

1. Constructor accepting five parameters: `pName`, `pClass`, `health`, `damage`, and `xp`.
   - Inside the constructor, set `maxHealth` equal to the `health` parameter passed in.
   - Then set `this.health` equal to `maxHealth`.

#### Methods:

- `levelUp()` → increases player statistics when leveling up:
  - Increase `maxHealth` by 140% (multiply by 1.4 and add to current)
  - Increase `damage` by 120% (multiply by 1.2 and add to current)
  - Set `health` to `maxHealth` (fully heal the player)
  - Increase `xpToLevel` by 120% (multiply by 1.2 and add to current)
  - Reset `xp` to 0

- `listPlayerStats()` → prints a formatted display of player statistics including:
  - Player name
  - Player class
  - Current health / maximum health
  - Current XP / XP needed to level
  - Current level

---

### 2. World Class

Create a class called `World` that manages the game state and story progression.

#### Class & Instance Variables:

- `int worldState` – tracks the current position in the game story (starts at 0).
- `zorkPlayer zP` – a reference to the player character object.

#### Methods:

- `getWorldState(int worldState)` – uses a switch statement to display story text based on the current `worldState` value:
  - **Case 0** → Display welcome message and prompt for character name
  - **Case 1** → Display class selection menu (Ranger, Fighter, Mage)
  - **Case 2** → Display opening game scene with action choices
  - **Case 3** → Display outcome of first choice
  - **Case 4** → Display outcome of second choice
  - *(You may add additional cases for extended gameplay)*

---

### 3. App Class (Main Application)

Create a class `App` that contains the main game logic and game loop.

#### Instance Variables:

- `Scanner scanner` – for reading user input from the console
- `World world` – instance of the World class
- `boolean isPlaying` – flag to control the main game loop
- Player creation variables: `pName`, `pClass`, `health`, `damage`, `xp`

#### Methods:

- `runtime()` – contains the main game logic:
  1. Initialize the game world and scanner
  2. Display the initial world state (case 0)
  3. Read player name input
  4. Change `worldState` to 1 and display class selection
  5. Read class choice and set appropriate stats:
     - **Ranger**: damage = 15
     - **Fighter**: damage = 20
     - **Mage**: damage = random value between 5 and 20
  6. Create a `zorkPlayer` object with the chosen attributes
  7. Set `isPlaying` to `true` and `worldState` to 2
  8. Enter main game loop (`while(isPlaying)`) that:
     - Displays current world state
     - Reads player input
     - Uses a switch statement to process commands based on current `worldState`
     - Updates `worldState` based on player choices
     - Allows player to view stats by typing "stats"

- `main(String[] args)` – entry point that calls `runtime()`

---
