# Markdown Note-taking App

## Description

The **Markdown Note-taking App** is a RESTful API that allows users to create, save, and manage notes written in Markdown format. In addition to basic note-taking functionality, the app includes advanced text processing capabilities, such as grammar checking and Markdown-to-HTML conversion. Users can upload files through the API, which requires handling file storage and preventing name conflicts.

## Features

- **File Upload**: Upload notes as files and store them persistently, ensuring unique filenames to avoid collisions.
- **Grammar Check**: Verify the grammar of a note's content through a dedicated endpoint.
- **Markdown Storage and Retrieval**: Save notes in Markdown format and retrieve them later.
- **Markdown-to-HTML Conversion**: Convert Markdown notes to HTML and retrieve the rendered version.

## Technologies Used

- **Backend Framework**: Spring Boot (Java)
- **Database**: MongoDB
- **File Storage**: Local filesystem
- **Libraries**:
  - For Java: Markdown processing libraries like commonmark.
  - Optional grammar-checking libraries like languagetool
- **API Protocol**: REST

## Setup and Installation

**1. Clone the Repository**

git clone https://github.com/WhoDoesFluttershyLike/URL-Shortening-Service.git

cd URL-Shortening-Service

**2. Install Dependencies**

mvn clean install

**3. Configure Database**

- Set up a database (MongoDB).

- Add your database configuration in the application.properties. In my case `mongodb://localhost:27017/mongodb`

**4. Run the Application**

mvn spring-boot:run

The application will start on http://localhost:8082
