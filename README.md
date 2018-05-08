<h1>Website Rot Link Tester</h1>
It would iteratively download all pages of a website (i.e., crawl the website) and try to access all URLs in the websites and record the HTTP status codes. If some links result in HTTP 4xx or HTTP 5xx error codes it will record those errors in a file. This can be used to test for link rot (i.e., outdated links that lead to no existing page).

<h2>Getting Started</h2>
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

<h3>Prerequisites</h3>
What things you need to install the software and how to install them.

```
JRE

Libraries - 
jsoup
```
<h2>Built With</h2>

```
Swing
jsoup
```

<h2> How to use it ? </h2>

The GUI looks like this. In the Text field provided in the GUI, user should paste the URL of the Website.

![User_Interface](/ui.jpg)

After the task is completed, Status message "Completed" -

![Completed](/completed.jpg)

All the Generated Links are saved in the file “Links.txt”, Sample saved Output File - 

![Saved Files Location](/output_file.jpg)

If the URL provided is not working,

![Wrong_URL](/Invalid_Domain.jpg)

<h3> Help </h3>

To get help at any point of time, click the “Help” button.


To contact for any query or feedbacks, simply drop a mail at – <br>

avinashkr226@gmail.com <br>


<h3>Author</h3>

[Avinash Kumar](https://www.linkedin.com/in/akavinashkumar)


<h2>License</h2>
This project is licensed under the MIT License - see the LICENSE.md file for details
