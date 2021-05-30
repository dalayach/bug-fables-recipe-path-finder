# bug-fables-recipe-path-finder

<script src="https://www.java.com/js/deployJava.js"></script>
<script>
    var url = "https://dalayach.github.io/TestClass.jnlp";
    deployJava.createWebStartLaunchButton(url, '1.6.0');
</script>

And if you can't see the orange "Launch" box, click <a href="TestClass.jnlp">HERE</a> instead!


UNFINISHED -- I will update this as changes are made, but right now, it is unfinished and still in progress.

This is a Java project that helps you unlock all of the remaining Bug Fables Recipes in your cookbook.

A common point of tedium amongst Bug Fables players is how unintuitive the recipes are, so as a result, most players finish the game with the cookbook mostly unfinished. Obviously, many players wish to 100% the game, but not all want to drag themselves through the slog of buying and cooking each recipe one at a time to unlock everything.

And that's where this project comes in. I had considered creating a manual, handwritten guide for finding the optimal path for cooking, but I realized that it wouldn't effectively cover the edgecase of the player having unlocked only half of their cookbook. And since everyone's "half" would look completely different, the best a manual guide could offer would be to list the one's most players are likely to miss.

Instead, I decided to create this program to address that concern. You click the checkboxes next to the list of items you want to make, then enter in how much inventory space you have (or are willing to use), then the program will plot out your path for you!

Obviously, this program is not flawless. But my goal here is to provide a feature to help make 100%'ing the game a lot less tedious. CRITICISM AND/OR FEEDBACK IS ALWAYS APPRECIATED!

Some notes about how I implemented this
 - I paid NO attention to price when making this. Frankly, the bank is ridiculously overpowered in this game, so I will be assuming that money is never a problem.
 - I am assuming you have access to ALL locations and tunnels in Bug Fables. You will be using almost all tunnels and locations if you wish to be optimal, so this is a must.
 - Physical walk distance is not considered. I am treating the tunnel center as the central point and treating each location as equidistant from that tunnel center. For example, the Golden Settlement Caravan is much closer to the Tunnel Center than the Bee Hive Factory Gift Shop, but as far as this algorithm is concerned, they are both the same distance from the Tunnel Center. Priority will be given to the location you are currently in. If you grabbed the last item you need for a batch at the Golden Emporium, it will send you to Kut for any cooking you need to do. This is because Kut is next to the Golden Emporium. Obviously, the code will check if Kut can actually MAKE all the items in your batch, but other than that, it will always prioritize your current location before sending you anywhere else to bake.
