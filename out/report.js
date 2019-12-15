$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("registrationCodersGuru.feature");
formatter.feature({
  "line": 1,
  "name": "registrationCodersGuru",
  "description": "",
  "id": "registrationcodersguru",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "New user registration on CodersGuru",
  "description": "",
  "id": "registrationcodersguru;new-user-registration-on-codersguru",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Go to the CodersGuru home page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "On the main page click the create account button",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "Complete all user registration fields \u003cemail\u003e \u003cfirst_name\u003e \u003clast_name\u003e \u003cpassword_1\u003e \u003cpassword_2\u003e \u003ctown\u003e \u003ccode_postal\u003e \u003cstreet\u003e \u003cnumber\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Clicking the register button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "We log out the newly registered user",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "We log in again to the newly created user confirming correct registration",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Close the browser window",
  "keyword": "And "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "registrationcodersguru;new-user-registration-on-codersguru;",
  "rows": [
    {
      "cells": [
        "email",
        "first_name",
        "last_name",
        "password_1",
        "password_2",
        "town",
        "code_postal",
        "street",
        "number"
      ],
      "line": 13,
      "id": "registrationcodersguru;new-user-registration-on-codersguru;;1"
    },
    {
      "cells": [
        "@wp.pl",
        "Leszek",
        "Kownacki",
        "qwerty123456",
        "qwerty123456",
        "Warszawa",
        "01-123",
        "Wyspianska",
        "45"
      ],
      "line": 14,
      "id": "registrationcodersguru;new-user-registration-on-codersguru;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "New user registration on CodersGuru",
  "description": "",
  "id": "registrationcodersguru;new-user-registration-on-codersguru;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Go to the CodersGuru home page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "On the main page click the create account button",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "Complete all user registration fields @wp.pl Leszek Kownacki qwerty123456 qwerty123456 Warszawa 01-123 Wyspianska 45",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Clicking the register button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "We log out the newly registered user",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "We log in again to the newly created user confirming correct registration",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Close the browser window",
  "keyword": "And "
});
formatter.match({
  "location": "registrationCodersGuru.GoToTheCodersGuruHomePage()"
});
formatter.result({
  "duration": 6067881964,
  "status": "passed"
});
formatter.match({
  "location": "registrationCodersGuru.onTheMainPageClickTheCreateAccountButton()"
});
formatter.result({
  "duration": 557855934,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "@wp.pl",
      "offset": 38
    },
    {
      "val": "Leszek",
      "offset": 45
    },
    {
      "val": "Kownacki",
      "offset": 52
    },
    {
      "val": "qwerty123456",
      "offset": 61
    },
    {
      "val": "qwerty123456",
      "offset": 74
    },
    {
      "val": "Warszawa",
      "offset": 87
    },
    {
      "val": "01-123",
      "offset": 96
    },
    {
      "val": "Wyspianska",
      "offset": 103
    },
    {
      "val": "45",
      "offset": 114
    }
  ],
  "location": "registrationCodersGuru.completeAllUserRegistrationFields(String,String,String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 1183551989,
  "status": "passed"
});
formatter.match({
  "location": "registrationCodersGuru.clickingTheRegisterButton()"
});
formatter.result({
  "duration": 1284085463,
  "status": "passed"
});
formatter.match({
  "location": "registrationCodersGuru.weLogOutTheNewlyRegisteredUser()"
});
formatter.result({
  "duration": 1117783157,
  "status": "passed"
});
formatter.match({
  "location": "registrationCodersGuru.weLogInAgainToTheNewlyCreatedUserConfirmingCorrectRegistration()"
});
formatter.result({
  "duration": 2273196100,
  "status": "passed"
});
formatter.match({
  "location": "registrationCodersGuru.closeTheBrowserWindow()"
});
formatter.result({
  "duration": 671987198,
  "status": "passed"
});
});