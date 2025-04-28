🕹️ TicTacToe REST API

A simple Spring Boot project to play TicTacToe game via RESTful APIs.
Integrated with Swagger UI using springdoc-openapi to easily test from the browser.
📦 Project Structure

TickTackToeController.java — REST APIs to start a game, make a move, get game state.
TickTackToeService.java — Business logic for the TicTacToe game.
Game.java — Model representing the board, player turn, and status.
MoveRequest.java — DTO to handle player moves.
TickTackToeException.java — Custom exception class.
🚀 How to Run

Clone the project:
git clone https://github.com/iamsujatasingh/tictactoe-rest-api.git
Navigate to the project folder:
cd tictactoe-api
Build and run the Spring Boot application:
./mvnw spring-boot:run
Open Swagger UI in your browser:
http://localhost:8080/swagger-ui.html
or
http://localhost:8080/swagger-ui/index.html
🛠️ Available APIs


Method	URL	Description
GET	/tick-tack-toe	Get the current game state
POST	/tick-tack-toe/startGame	Start a new TicTacToe game
POST	/tick-tack-toe/makeMove	Make a move (row, col) for the current player
📜 Example API Usage

➡️ Start New Game
POST /tick-tack-toe/startGame
Response:
{
  "board": [
    ["", "", ""],
    ["", "", ""],
    ["", "", ""]
  ],
  "currentPlayer": "X",
  "gameStatus": "IN_PROGRESS"
}
➡️ Make a Move
POST /tick-tack-toe/makeMove
Request Body:
{
  "row": 0,
  "col": 1
}
Response:
{
  "board": [
    ["X", "", ""],
    ["", "", ""],
    ["", "", ""]
  ],
  "currentPlayer": "O",
  "gameStatus": "IN_PROGRESS"
}
➡️ Get Current Game State
GET /tick-tack-toe
Response:
{
  "board": [
    ["X", "O", "X"],
    ["O", "X", "O"],
    ["X", "O", "X"]
  ],
  "currentPlayer": "O",
  "gameStatus": "DRAW"
}
📚 Swagger UI

After starting the application, visit:
http://localhost:8080/swagger-ui/index.html
You can try all the APIs directly from the browser without Postman or curl!
⚙️ Tech Stack

Java 17+
Spring Boot 3.4.5
Maven
Springdoc OpenAPI 2.8.6 (for Swagger Integration)
📝 Author

Name: Sujata Singh
Email: sujatasingh1991@gmail.com
GitHub: https://github.com/iamsujatasingh