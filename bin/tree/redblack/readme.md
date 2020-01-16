

RedBlack Tree properties:
1) Color of each node is either RED or BLACK
2) Root node is always BLACK
3) No 2 adjascent RED node
4) Number of black in every path is same 

Insert:
	Add new node to TREE and color it RED. 


Case 1: When root is null.
	Add root node and color it BLACK

Case 2: Uncle == BLACK
	
	Case 2a: Uncle == null (i.e. Parent == RED and GrandParent == BLACK)
		New node = RED (Violates 3 RED-RED rule)
		Parent = BLACK, GP = RED
		Rotate
	
	Case 2b: Uncle != null (i.e. Parent = BLACK. GP color does not matter)
		New node = RED

Case 3: Uncle == RED
	
	Case 3a: Uncle has black children (i.e. Parent = BLACK, GP = RED)
		New node = RED
		
	Case 3b: Uncle has no child (i.e. Parent = RED, GP = RED) 
		New node = RED, Parent = BLACK, Uncle = BLACK
		Fix recursively for Grand Parent
		

DELETE


		
		



