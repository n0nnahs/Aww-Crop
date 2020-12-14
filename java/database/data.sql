BEGIN TRANSACTION;

 INSERT INTO crops 
 (
     name,
     yield_lbs_per_square_foot,
     crops_per_square_foot,
     seed_cost,
     description
 ) 
 VALUES
 (
     'Beets',
     0,
     9,
     2.08,
     'Beets are a unique root vegetable edible for both its bulb and green tops. The vegetable is a biennial, which means they flower and seed in their second year of growth, but beets are typically grown as an annual. This vegetable’s growing seasons are early spring to early to early summer or late summer to late fall, as it prefers cooler weather. Beets come in a popular red hue, as well as gold, striped and white varieties.'
 ),
 (
     'Broccoli',
     0,
     1,
     6.25,
     'Broccoli is a hardy, cool-season vegetables bringing colorful green nutrients to the table. Broccoli is part of the Cole Crop family, which also includes cabbage, kohlrabi, kale and more. It can be grown twice a year, in the late spring and the fall.'
 ),
 (
     'Brussels-Sprouts',
     0,
     1,
     7.50,
     'Brussels sprouts belong to the Cole Crop family and grow throughout a long season with a fall harvest. They can be prepared in various ways, such as roasting, boiling or eaten in thin shavings.'
 ),
 (
     'Cabbage',
     0,
     1,
     6.25,
     'Cabbage is a fairly easy to plant to grow, as it is a hardy vegetable, and also comes in different colors, such as red, green and white. Most cabbages will have smooth, tightly packed heads of leaves, but some varietals have crinkled leaves. Cabbage belongs to the Cole Crop family, like broccoli and Brussels sprouts and has more vitamin C than oranges.'
 ),
 (
     'Carrots',
     0,
     12,
     1.56,
     'Carrots bring bountiful nutrients to the table, as well as a burst of color. Other than the typical orange, carrots can be found in red, white, rainbow and purple colors. Carrots are rich in vitamin A, which helps prevent poor eyesight. In addition to being a tasty treat to humans, they also make a healthy treat for pets.'
 ),
 (
     'Cauliflower',
     0,
     1,
     6.25,
     'Cauliflower is a relative to broccoli and cabbage, and it is a cool-season vegetable, which makes it best for a fall harvest. It is a bit pickier than its green-budded relative, as it does not tolerate excessive heat or cold very well. Cauliflower requires consistent temperatures of around 60 degrees. Experienced gardeners may have more success with cauliflower than beginners.'
 ),
 (
     'Celery',
     0,
     4,
     7.50,
     'Celery is a low-calorie, high-nutrient vegetable used for its seeds, stalks and leaves. The vegetable is most often used as a garnish or a healthy snack, and it’s popular amongst grocery shoppers for its cheap cost. Celery tastes better grown from the garden, but to grow celery requires patience and skill. Celery has a long growing season, requires lots of water and has tricky-to-plant seeds.'
 ),
 (
     'Corn',
     0,
     4,
     3.13,
     'Sweet corn is a popular summer vegetable to grow in the home garden. Many cornfields consist of fields corn, which is starchier but sweet corn, like its name, has a sweeter taste and the kernels are softer. Different types of sweet corn should not be planted together. Corn comes in many different varieties but if planted near each other, the types can cross and create a starchier corn.'
 ),
 (
     'Cucumbers',
     0,
     2,
     3.75,
     'Cucumbers can be grown for fresh eating, pickling and more. They range in flavor, colors, shapes and sizes. Some cucumbers are known as lemon cucumbers and are yellow. Cucumbers can grow in circles, elongated spheres and more.'
 ),
 (
     'Lettuce',
     0,
     2,
     3.13,
     'Homegrown lettuce offers more vitamins and variety than that bought at the store, and it can add color to tossed salads and other dishes. Lettuce is an excellent source of vitamin A.'
 ),
 (
     'Onions',
     0,
     3,
     3.13,
     'A way to jazz up any dish is to add some onions to it. Onions can be grown from seed or from sets, which are immature onion bulbs. There are more opportunities for gardeners if onions are grown from seed, and the outcome is rewarding. There are different kinds of onions, such as short-day onions which grow best in the south and long-day onions which grow best in northern climates. Pick the correct variety for your garden.'
 ),
 (
     'Peas',
     0,
     6,
     2.50,
     'Peas are a cool-weather vegetable, meaning they flourish in the spring and fall months. The two main different types of peas are shelling peas and edible-podded peas. Shelling peas are grown for the peas hidden inside the pod. Once shelled, discard the pod. Edible-podded peas can be eaten whole, pod and all.'
 ),
 (
     'Peppers',
     0,
     1,
     6.25,
     'Peppers come in all different shapes, sizes and flavors with the most common being the bell pepper. They range in flavors from sweet and mild to extra hot and can be eaten raw, stuffed or added to recipes. Although some gardeners purchase pepper plant starters instead of growing the plant from seed, gardeners who opt to grow plants from seed will have more options when it comes to the type of pepper plants they want.'
 ),
 (
     'Potatoes',
     0,
     4,
     6.25,
     'Potatoes are an excellent carb source and culinary staple that can be added to roasts, stews or as an addition to a meal. They come in various colors and shapes, such as the traditional Yukon gold to purple fingerling potatoes. Potatoes can be grown from true seed or seed potatoes, which are pieces of a cut-up potato.'
 ),
 (
     'Radishes',
     0,
     14,
     3.13,
     'Radishes are the perfect vegetable for new gardeners, as the roots are ready to harvest in as little as 21 days. Radishes can be eaten raw or added to salads for an extra crunch with a bit of flavor. Although oftentimes the tops are composted, radish greens also can be eaten by sautéing them in a pan or adding raw greens with the radishes to a salad.'
 ),
 (
     'Spinach',
     0,
     9,
     3.75,
     'Nutrient-dense, brilliant green and a quick growing crop which yields leafy pickings during multiple seasons, spinach is a great choice for beginning gardeners. Spinach is known as a cool-weather plant, meaning it excels in the spring and fall months. During the summer, the plant will produce a flowering stalk and bitter leaves. This is called bolting. Different varietals of spinach can be used to create a colorful bouquet of varying tastes in one’s garden.'
 ),
 (
     'Tomatoes',
     0,
     1,
     6.25,
     'Tomatoes are one of the most common plants grown in the garden, but they are usually grown from transplants bought at the store and not seeds. However, growing a tomato from seed allows for more options when it comes to the type of tomatoes a gardener wants to grow. Tomatoes range from typical red to yellow to seedless and heirloom varieties. Homegrown tomatoes taste delicious fresh, or they can be used for canning, sauces and other recipes.'
 ),
 (
     'Turnips',
     0,
     9,
     3.75,
     'Turnips are a unique vegetable in which both parts, the root and the leafy greens on the top, can be eaten. Some turnips are grown primarily for their turnip greens, while others are grown to harvest the root. Turnips are commonly used in soups or stews and the turnip greens can be used in salads or cooked.'
 );
 
 -- FAKE TEMPORARY DATA FOR TESTING
 -- Username: test@test
 -- Password: test
 
 INSERT INTO users (user_id,username,password_hash,role) VALUES (101,'test@test','$2a$10$77wEyLK.8WdPMfsvD60iYetDMsXq5FjFBhoqbz5RaDDfhm9ZeIAKa','ROLE_USER');
 
 -- Dummy data: active plot
 
 INSERT INTO plot 
 (
     plot_id,
     name,
     width,
     length,
     active
 ) 
 VALUES 
 (
     101,
     'My First Plot',
     4,
     4,
     't'
 );
 
 INSERT INTO users_plot
 (
     user_id,
     plot_id
 ) 
 VALUES 
 (
     101,
     101
 );
 
 INSERT INTO plot_coords
 (
     coords_id,
     crop_id,
     plot_id,
     x,
     y
 ) 
 VALUES 
 (
     101,
     6,
     101,
     0,
     0
 ),
 (
     102,
     6,
     101,
     0,
     1
 ),
 (
     103,
     6,
     101,
     0,
     2
 ),
 (
     104,
     6,
     101,
     0,
     3
 ),
 (
     105,
     10,
     101,
     1,
     0
 ),
 (
     106,
     10,
     101,
     1,
     1
 ),
 (
     107,
     10,
     101,
     1,
     2
 ),
 (
     108,
     10,
     101,
     1,
     3
 ),
 (
     109,
     17,
     101,
     2,
     0
 ),
 (
     110,
     17,
     101,
     2,
     1
 ),
 (
     111,
     17,
     101,
     2,
     2
 ),
 (
     112,
     17,
     101,
     2,
     3
 ),
 (
     113,
     13,
     101,
     3,
     0
 ),
 (
     114,
     13,
     101,
     3,
     1
 ),
 (
     115,
     13,
     101,
     3,
     2
 ),
 (
     116,
     13,
     101,
     3,
     3
 );
 
 INSERT INTO notes
 (
     note_id,
     plot_id,
     note
 ) 
 VALUES 
 (
     101,
     101,
     'This is the best plot there ever was.'
 ),
 (
     103,
     101,
     'This is also a note'
 );
 
 -- Dummy data: inactive plot
 
  INSERT INTO plot 
 (
     plot_id,
     name,
     width,
     length,
     active
 ) 
 VALUES 
 (
     102,
     'My Worst Plot',
     3,
     3,
     'f'
 );
 
 INSERT INTO users_plot
 (
     user_id,
     plot_id
 ) 
 VALUES 
 (
     101,
     102
 );
 
 INSERT INTO plot_coords
 (
     coords_id,
     crop_id,
     plot_id,
     x,
     y
 ) 
 VALUES 
 (
     117,
     2,
     102,
     0,
     0
 ),
 (
     118,
     3,
     102,
     0,
     1
 ),
 (
     119,
     4,
     102,
     0,
     2
 ),
 (
     120,
     5,
     102,
     1,
     0
 ),
 (
     121,
     6,
     102,
     1,
     1
 ),
 (
     122,
     7,
     102,
     1,
     2
 ),
 (
     123,
     8,
     102,
     2,
     0
 ),
 (
     124,
     9,
     102,
     2,
     1
 ),
 (
     125,
     10,
     102,
     2,
     2
 );
 
 INSERT INTO notes
 (
     note_id,
     plot_id,
     note
 ) 
 VALUES 
 (
     102,
     102,
     'This is the worst plot there ever was.'
 );

COMMIT TRANSACTION;