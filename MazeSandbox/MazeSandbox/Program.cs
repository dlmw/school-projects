using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using Microsoft.VisualBasic.CompilerServices;
using TalesOfSenylan.Models.Dungeon;

namespace MazeSandbox
{
    class Cell
    {
        public bool visited;
        public Dictionary<CardinalPoint, Cell> exits = new Dictionary<CardinalPoint, Cell>();
        public Vector2 position;

        public Cell(Vector2 position)
        {
            this.position = position;
        }
    }

    class Maze
    {
        private int width;
        private int height;
        private Cell startingCell;
        
        private List<List<Cell>> cells = new List<List<Cell>>();
        private static Random random = new Random();
        private Stack<Cell> lastCells = new Stack<Cell>();

        public Maze(int width, int height)
        {
            this.width = width;
            this.height = height;
            
            for (int i = 0; i < height; i++)
            {
                List<Cell> cellsRow = new List<Cell>();
                for (int j = 0; j < width; j++)
                {
                    Cell c = new Cell(new Vector2(j, i));
                    cellsRow.Add(c);
                }
                cells.Add(cellsRow);
            }
            
            startingCell = GetRandomCell();
            VisitCell(startingCell);
        }

        private void VisitCell(Cell cell)
        {
            if (!cell.visited)
            {
                lastCells.Push(cell);
            }
            cell.visited = true;
            
            // Puis on regarde quelles sont les cellules voisines possibles et non visitées. 
            List<Cell> adjacentUnvisitedCells = GetAdjacentUnvisitedCells(cell);
            if (adjacentUnvisitedCells.Count > 0)
            {
                // S'il y a au moins une possibilité, on en choisit une au hasard, on ouvre le mur et on recommence avec la nouvelle cellule. 
                Cell selectedExit = GetRandomAdjacentUnvisitedCell(cell);

                CardinalPoint cp = GetExitFromCell(cell, selectedExit);
                
                cell.exits.Remove(cp);
                cell.exits.Add(cp, selectedExit);

                selectedExit.exits.Remove(cp.Opposite());
                selectedExit.exits.Add(cp.Opposite(), cell);
                
                VisitCell(selectedExit);
            }
            // Lorsque l'on est revenu à la case de départ et qu'il n'y a plus de possibilités, le labyrinthe est terminé. 
            else if (lastCells.Count > 0 && startingCell.Equals(lastCells.Peek()))
            {
                return;
            }
            // S'il n'y en pas, on revient à la case précédente et on recommence.
            else
            {
                if (lastCells.Count > 0)
                {
                    lastCells.Pop();
                    VisitCell(lastCells.Peek());
                }
            }
        }

        private CardinalPoint GetExitFromCell(Cell startingCell, Cell targetCell)
        {
            if (startingCell.position.X.Equals(targetCell.position.X))
            {
                if (startingCell.position.Y - targetCell.position.Y == 1)
                {
                    return CardinalPoint.NORTH;
                }
                if (startingCell.position.Y - targetCell.position.Y == -1)
                {
                    return CardinalPoint.SOUTH;
                }
            }
            else if (startingCell.position.Y.Equals(targetCell.position.Y))
            {
                if (startingCell.position.X - targetCell.position.X == 1)
                {
                    return CardinalPoint.WEST;
                }
                if (startingCell.position.X - targetCell.position.X == -1)
                {
                    return CardinalPoint.EAST;
                }
            }

            return CardinalPoint.NORTH; // This means there is an error (potential TODO)
        }

        private Cell GetRandomAdjacentUnvisitedCell(Cell cell)
        {
            List<Cell> adjacentUnvisitedCells = GetAdjacentUnvisitedCells(cell);
            return adjacentUnvisitedCells[random.Next(adjacentUnvisitedCells.Count)];
        }

        private List<Cell> GetAdjacentUnvisitedCells(Cell cell)
        {
            List<Cell> adjacentUnvisitedCells = new List<Cell>();

            List<Cell> adjacentCells = GetAdjacentCellsOfCell(cell);
            foreach (Cell adjacentCell in adjacentCells)
            {
                if (!adjacentCell.visited)
                {
                    adjacentUnvisitedCells.Add(adjacentCell);
                }
            }
            
            return adjacentUnvisitedCells;
        }

        private Cell GetRandomCell()
        {
            int randomX = random.Next(width);
            int randomY = random.Next(height);

            return cells[randomX][randomY];
        }

        private List<Cell> GetAdjacentCellsOfCell(Cell cell)
        {
            List<Cell> adjacentCells = new List<Cell>();
            
            foreach (List<Cell> cellsRow in cells)
            {
                foreach (Cell c in cellsRow)
                {
                    if (IsAdjacent(c, cell))
                    {
                        adjacentCells.Add(c);
                    }
                }
            }
            
            return adjacentCells;
        }

        private static bool IsAdjacent(Cell c1, Cell c2)
        {
            if (AreOnDifferentColumnsAndRows(c1, c2))
            {
                return false;
            }
            
            return IsAdjacentX(c1, c2) || IsAdjacentY(c1, c2);
        }

        private static bool IsAdjacentX(Cell c1, Cell c2)
        {
            if (c1.position.X + 1 == c2.position.X || c1.position.X - 1 == c2.position.X)
            {
                return true;
            }

            return false;
        }
        
        private static bool IsAdjacentY(Cell c1, Cell c2)
        {
            if (c1.position.Y + 1 == c2.position.Y || c1.position.Y - 1 == c2.position.Y)
            {
                return true;
            }
            
            return false;
        }

        private static bool AreOnDifferentColumnsAndRows(Cell c1, Cell c2)
        {
            return c1.position.X != c2.position.X && c1.position.Y != c2.position.Y;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Maze m = new Maze(3, 3);
        }
    }
}