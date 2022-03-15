# Overview:
The following repo contains an implementation of a Football World Cup Score Board as a simple library.

# Implementation assumptions:
1. Team and match are abstract entities that have a few basic features such as name and id, etc. The football team and 
the football match inherit from them and extend them.

2. Each sport has its own scoreboard, but a scoreboard should generally include at least four services: starting the 
game, updating the results, finishing the game, and summarizing the results of the games. Therefore, the scoreboard is 
an interface, and as a result, the scoreboards of other sports are obliged to implement its four main services according
to the characteristics of that sport. They can also create other services if needed.

3. In general, implementing a scoreboard requires a repository of teams and matches. A repository must provide services
such as add, update, delete, and find objects with the input key. So team repository and match repository are
interfaces, and football team repository and football match repository implement them. This allows a class (for 
example, a scoreboard) to implement both of them.

4. The total score of a match in different sports may vary, so it is implemented as an abstract method.

5. No more than one session of scoreboards and repositories is created, so they can be implemented with a singleton 
pattern.

6. A match can be created in several ways, for example, just by presenting two teams (mandatory), by presenting two 
teams with their scores or their coaches, etc., so it can be implemented with a builder pattern.

7. A match cannot start again unless it has been finished.

8. You can not finish a match while it has not started at all

9. A team cannot play in more than one match at the same time.

10. A team score can not be a negative number.

11. The team name must contains only the letters and a maximum of 15  characters and must start with an uppercase 
character.

12. Teams with the same id (name) should not be stored in the repository.

#Guidelines for running 
 This library is implemented with Test-Driven Development (TDD) approach and it is in a frontend language. It is 
 recommended to run and manipulate the test classes in order to understand the code.
 
 # Support
 Please enter an issue in the repo for any questions or problems.
 Alternatively, please contact me at meisam.yari71@gmail.com
 
 
 Copyright 2019 Province of British Columbia
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at 
 
    http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 
 
 

