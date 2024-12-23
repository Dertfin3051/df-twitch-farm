# DF Twitch Farm
**DF Twitch Farm** - Easy to use program for farming points using drops on Twitch.

**ATTENTION!!! <u>Use this program at your own risk</u>, as software of this nature <u>is not approved by the Twitch rules</u> and your account may be blocked!**

## Installation

1. **First, install Java 21 or higher.**  
It can be installed from the [official Oracle website](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html). Please note that earlier versions of Java will not be supported.
2. **Download actual jar-file**  
It can be found on the [latest release page](https://github.com/Dertfin3051/df-twitch-farm/releases/latest)
3. **Run program to create config**  
Open console and run command like this:  
`java -jar installed-jar.jar`  
Now, just close it :D  
After the first launch, a `config.json` file will appear in the folder where the program was launched.
4. **Configure program settings**  
   This one may seem tricky, but it only needs to be done once.  
   1. Go to any broadcast and wait for the green “Drop!” button to appear.
   2. Take a screenshot of the <u>**entire**</u> screen - from the top left point to the bottom right point.
   3. Go to Paint or a similar application and paste the screenshot you took.
   4. Aim at the green area of the "Drop!" button. and look at its coordinates (x,y)  
      Specify the received coordinates in the `config.json` file:
      ```json
        "claim-button-position" : {
            "x" : YOUR_X,
            "y" : YOUR_Y
        }
      ```
   5. Select the eyedropper tool and color the Drop! button green. In the settings of the selected color, find the RGB parameters.  
      Next, simply enter them into `config.json`:
      ```json
        "claim-button-color" : {
            "R" : COLOR_R,
            "G" : COLOR_G,
            "B" : COLOR_B
        }
      ```
   You should have a config like this:
   ```json
    {
        "claim-button-position" : {
            "x" : 1666,
            "y" : 1000
        },
        "claim-button-color" : {
            "R" : 0,
            "G" : 219,
            "B" : 132
        }
    }
   ```
5. Launch the program and press Enter on your keyboard for it to start working. The launch method is described in paragraph 3
6. Open the stream window and leave the computer to farm points :D