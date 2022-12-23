package ia;

public class IA {
	
	
	private final static int COORD_AUTOUR [][] = {{0,-1},{1,-1},{-1,0},{1,0},{1,-1},{1,0}};
	private static final int MAX_RECURSION = 5;
	
	
	public String getCoup(String plateau) {
		int[][] board = StringToBoard(plateau);
		int [] coup = findOptimalMove(board, trouverJoueur(board));
		return (char)('A'+coup[0])+""+(coup[1]+1);
	}
	
	private static int trouverJoueur(int[][] board) {
		int joueur = -1;
		int taille = board.length;
		for(int i = 0; i<taille; i++)
			for(int j = 0; j<taille; j++) {
				if(board[i][j] == 1) {
					joueur += 2;
				}
				else if(board[i][j] == -1) {
					joueur -= 2;
				}
			}
		return joueur;
	}
	
	private static int charToInt(char c) {
		switch(c) {
			case 'X': return 1;
			case 'O': return -1;
			default: return 0;
		}
	}
	
	
	private static int[][] StringToBoard(String plateau){
		int taille = (int) Math.sqrt(plateau.length());
		int[][] board = new int[taille][taille];
		for(int i = 0; i<taille; i++)
			for(int j = 0; j<taille; j++) {
				board[j][i] = charToInt(plateau.charAt(j+i*taille));
			}
		return board;
	}
	
	
	public static int evaluerBoard(int[][] board, int player) {
	    // On commence par initialiser la valeur à 0
	    int value = 0;

	    // On parcourt toutes les cases du plateau
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[i].length; j++) {
	            // Si la case appartient au joueur courant
	            if (board[i][j] == player) {
	                // On ajoute la valeur de la case au total
	                value += getCaseValue(board, i, j, player);
	            }
	        }
	    }

	    // On retourne la valeur finale
	    return value;
	}

	public static int getCaseValue(int[][] board, int i, int j, int player) {
	    // Cette fonction renvoie la valeur d'une case en fonction de sa position sur le plateau et de la position des cases adjacentes
	    int value = 0;
	    // On parcourt les cases adjacentes
	    for (int x = Math.max(0, i - 1); x <= Math.min(board.length - 1, i + 1); x++) {
	        for (int y = Math.max(0, j - 1); y <= Math.min(board[i].length - 1, j + 1); y++) {
	            // Si la case adjacente appartient au joueur courant
	            if (board[x][y] == player) {
	                // On ajoute la valeur de la case adjacente au total
	                value += getAdjacentCaseValue(board, x, y, player);
	            } else if (board[x][y] != 0) {
	                // Si la case adjacente appartient à l'adversaire, on soustrait sa valeur au total
	                value -= getAdjacentCaseValue(board, x, y, player) / 2;
	            }
	        }
	    }
	    // On ajoute une valeur supplémentaire si la case est adjacente à un côté du plateau
	    if (isAdjacentToSide(board, i, j)) {
	        value += 1;
	    }
	    // On ajoute une valeur supplémentaire si la case est éloignée des coins du plateau
	    value += IA.getDistanceToClosestCorner(board, i, j);
	    // On retourne la valeur finale
	    return value;
	}

	public static int getAdjacentCaseValue(int[][] board, int i, int j, int player) {
	    // Cette fonction renvoie la valeur d'une case adjacente en fonction de sa position sur le plateau
	    int value = 0;
	    // On vérifie la position de la case sur le plateau
	    if (i == 0 || i == board.length - 1) {
	        // Si la case est sur le bord haut ou bas du plateau, elle a une valeur plus élevée
	        value += 2;
	    }
	    if (j == 0 || j == board[i].length - 1) {
	        // Si la case est sur le bord gauche ou droit du plateau, elle a une valeur plus élevée
	        value += 2;
	    }
	    // On vérifie si la case est adjacente à une case appartenant au joueur courant
	    if (isAdjacentToPlayer(board, player, i, j)) {
	        // Si oui, on ajoute une valeur supplémentaire
	        value++;
	    }
	    // On retourne la valeur finale
	    return value;
	}

	public static boolean isAdjacentToSide(int[][] board, int i, int j) {
	    // Cette fonction vérifie si la case pass
		// Cette fonction vérifie si la case passée en paramètre est adjacente à un côté du plateau

		// On parcourt les cases adjacentes
		for (int x = Math.max(0, i - 1); x <= Math.min(board.length - 1, i + 1); x++) {
		    for (int y = Math.max(0, j - 1); y <= Math.min(board[i].length - 1, j + 1); y++) {
		        // Si la case adjacente est vide et qu'elle se trouve sur un bord du plateau, la case courante est adjacente à un côté du plateau
		        if (board[x][y] == 0 && (x == 0 || x == board.length - 1 || y == 0 || y == board[i].length - 1)) {
		            return true;
		        }
		    }
		}
		// Si aucune case adjacente n'est vide et sur un bord du plateau, la case courante n'est pas adjacente à un côté du plateau
		return false;
	}
	
	public static boolean isAdjacentToPlayer(int[][] board, int player, int i, int j) {
	    // Cette fonction vérifie si la case passée en paramètre est adjacente à une case appartenant au joueur passé en paramètre

	// On parcourt les cases adjacentes
	for (int x = Math.max(0, i - 1); x <= Math.min(board.length - 1, i + 1); x++) {
	    for (int y = Math.max(0, j - 1); y <= Math.min(board[i].length - 1, j + 1); y++) {
	        // Si la case adjacente appartient au joueur, la case courante est adjacente à une case appartenant au joueur
	        if (board[x][y] == player) {
	            return true;
	        }
	    }
	}
	// Si aucune case adjacente n'appartient au joueur, la case courante n'est pas adjacente à une case appartenant au joueur
	return false;
	}
	
	public static int getDistanceToClosestCorner(int[][] board, int x, int y) {
	    // Cette fonction calcule la distance entre une case et le coin du plateau le plus proche
	    int minDistance = Integer.MAX_VALUE;
	    // On parcourt les coins du plateau
	    for (int i = 0; i < board.length; i += board.length - 1) {
	        for (int j = 0; j < board[i].length; j += board[i].length - 1) {
	            // On calcule la distance entre la case et le coin courant
	            int distance = Math.abs(x - i) + Math.abs(y - j);
	            // On met à jour la distance minimale si nécessaire
	            minDistance = Math.min(minDistance, distance);
	        }
	    }
	    // On retourne la distance minimale
	    return minDistance;
	}


    
    public static int[] findOptimalMove(int[][] board, int player) {
        int bestRow = -1;
        int bestCol = -1;
        int bestEvaluation = Integer.MIN_VALUE;

        // On parcourt toutes les cases du plateau
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // Si la case est vide, on vérifie si le coup joué sur cette case est optimal
                if (board[i][j] == 0) {
                    // On simule le coup en plaçant notre pion sur cette case
                    board[i][j] = player;
                    // On appelle l'algorithme Minimax pour évaluer l'état du plateau après ce coup
                    int evaluation = minimax(board, player, Integer.MIN_VALUE, Integer.MAX_VALUE, false, MAX_RECURSION);
                    // Si l'évaluation de ce coup est meilleure que les précédents, on met à jour les coordonnées du meilleur coup
                    //System.out.println((char)('A'+i)+""+(j+1)+" "+evaluation);
                    if (evaluation > bestEvaluation) {
                        bestRow = i;
                        bestCol = j;
                        bestEvaluation = evaluation;
                    }
                    // On annule le coup en remettant la case à vide
                    board[i][j] = 0;
                }
            }
        }

        // On renvoie les coordonnées du meilleur coup trouvé
        return new int[] {bestRow, bestCol};
    }
    
    private static int minimax(int[][] board, int player, int alpha, int beta, boolean maximizingPlayer, int rec) {
        // Si l'un des joueurs a gagné, on renvoie l'évaluation du plateau correspondante
        if (checkWin(board, player)) {
            return Integer.MAX_VALUE;
        } else if (checkWin(board, -player)) {
        	
            return Integer.MIN_VALUE;
        }
        
        

        // Si toutes les cases du plateau sont occupées
        if (isFull(board)) {
            return evaluerBoard(board, player)-5;
        }
        else if(rec <= 0) {
        	return evaluerBoard(board, player);
        }
        // Si c'est au tour du joueur maximal de jouer (notre joueur), on cherche le coup qui donne l'évaluation la plus élevée
        if (maximizingPlayer) {
            int bestEvaluation = Integer.MIN_VALUE;

            // On parcourt toutes les cases du plateau
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    // Si la case est vide, on simule le coup joué sur cette case
                    if (board[i][j] == 0) {
                        board[i][j] = player;
                        // On appelle récursivement minimax pour évaluer l'état du plateau après ce coup
                        int evaluation = minimax(board, player, alpha, beta, false, rec-1);
                        // On met à jour l'évaluation la plus élevée trouvée jusqu'à présent
                        bestEvaluation = Math.max(bestEvaluation, evaluation);
                        // On met à jour alpha (borne supérieure de l'intervalle de recherche)
                        alpha = Math.max(alpha, bestEvaluation);
                        // On annule le coup en remettant la case à vide
                        board[i][j] = 0;
                        // Si beta (borne inférieure de l'intervalle de recherche) est inférieure à alpha, on arrête la recherche car aucun autre coup ne pourra améliorer l'évaluation
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }

            return bestEvaluation;
        }
        // Si c'est au tour du joueur minimal de jouer (l'adversaire), on cherche le coup qui donne l'évaluation la plus basse
        else {
            int bestEvaluation = Integer.MAX_VALUE;

            // On parcourt toutes les cases du plateau
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    // Si la case est vide, on simule le coup joué sur cette case
                    if (board[i][j] == 0) {
                        board[i][j] = -player;
                        // On appelle récursivement minimax pour évaluer l'état du plateau après ce coup
                        int evaluation = minimax(board, player, alpha, beta, false, rec-1);
                        // On met à jour l'évaluation la plus basse trouvée jusqu'à présent
                        bestEvaluation = Math.min(bestEvaluation, evaluation);
                        // On met à jour beta (borne inférieure de l'intervalle de recherche)
                        beta = Math.min(beta, bestEvaluation);
                        // On annule le coup en remettant la case à vide
                        board[i][j] = 0;
                        // Si beta est inférieure à alpha, on arrête la recherche car aucun autre coup ne pourra améliorer l'évaluation
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }

            return bestEvaluation;
        }
    }

	private static boolean isFull(int[][] board) {
		
		for(int[] c : board) {
			for(int l : c) {
				if(l==0) return false;
			}
		}
		return true;
	}

	public static boolean checkWin(int[][] board, int player) {
	    // On parcourt toutes les cases du plateau
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[i].length; j++) {
	            // Si la case appartient au joueur courant
	            if (board[i][j] == player) {
	                // On vérifie si le joueur a gagné en parcourant les cases adjacentes
	                if (checkAdjacent(board, player, i, j, new boolean[board.length][board[i].length], 0)) {
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}

	public static boolean checkAdjacent(int[][] board, int player, int i, int j, boolean[][] visited, int direction) {
	    // Cette fonction récursive vérifie si le joueur a gagné en parcourant les cases adjacentes
	    // Elle prend en compte la direction dans laquelle le joueur se dirige (haut, bas, gauche, droite ou diagonale) pour savoir quelles cases sont adjacentes
	    // Elle utilise un tableau de booléens pour marquer les cases déjà visitées afin de ne pas boucler indéfiniment dans le cas où le plateau est cyclique

	    // Si la case courante appartient au joueur courant
	    if (board[i][j] == player) {
	        // On marque la case comme visitée
	        visited[i][j] = true;
	        // On vérifie si le joueur a gagné en parcourant les cases adjacentes dans chaque direction
	        if (direction != 1 && i > 0 && !visited[i - 1][j]) {
	            // On parcourt la case du haut
	            if (checkAdjacent(board, player, i - 1, j, visited, 2)) {
	                return true;
	            }
	        }
	        if (direction != 2 && i < board.length - 1 && !visited[i + 1][j]) {
	            // On parcourt la case du bas
	            if (checkAdjacent(board, player, i + 1, j, visited, 1)) {
	                return true;
	            }
	        }
	        if (direction != 3 && j > 0 && !visited[i][j - 1]) {
	            // On parcourt la case de gauche
	            if (checkAdjacent(board, player, i, j - 1, visited, 4)) {
	                return true;
	            }
	        }
	        if (direction != 4 && j < board[i].length - 1 && !visited[i][j + 1]) {
	            // On parcourt la case de droite
	            if (checkAdjacent(board, player, i, j + 1, visited, 3)) {
	                return true;
	            }
	        }
	        /*if (direction != 5 && i > 0 && j > 0 && !visited[i - 1][j - 1]) {
	            // On parcourt la case en diagonale à gauche en haut
	            if (checkAdjacent(board, player, i - 1, j - 1, visited, 6)) {
	                return true;
	            }
	        }
	        if (direction != 6 && i < board.length - 1 && j < board[i].length - 1 && !visited[i + 1][j + 1]) {
	            // On parcourt la case en diagonale à droite en bas
	            if (checkAdjacent(board, player, i + 1, j + 1, visited, 5)) {
	                return true;
	            }
	        }*/
	        if (direction != 7 && i > 0 && j < board[i].length - 1 && !visited[i - 1][j + 1]) {
	            // On parcourt la case en diagonale à droite en haut
	            if (checkAdjacent(board, player, i - 1, j + 1, visited, 8)) {
	                return true;
	            }
	        }
	        if (direction != 8 && i < board.length - 1 && j > 0 && !visited[i + 1][j - 1]) {
	            // On parcourt la case en diagonale à gauche en bas
	            if (checkAdjacent(board, player, i + 1, j - 1, visited, 7)) {
	                return true;
	            }
	        }
	    }
        // Si aucune case adjacente n'appartient au joueur, on retourne false
        return false;
	    
	}


}
