# forge-generation-service
Spring server for portfolio generation and distribution


Current bugs/functionality gaps:
Unable to create a new portfolio from the UI. Clicking the "Create a Portfolio" button brings up an existing portfolio. Need to create a new portfolio object and a blank portfolio view.

When editing an existing portfolio, changes to industry equivalency, skill matrix, and all aspects of projects (except project names) do not persist. Deleting a project does not persist. Submit button for edited portfolios does not work.

Unable to add more than one degree to the education section of a portfolio; if a degree is already listed, the add button will replace the existing entry with a new one.

PDF functionality does not exist on the front end, and PDFs can't currently be stored to the Revature s3 bucket. Further info on this issue can be found in the PDF Generation Service project. Also, an important user story we didn't consider: An admin should be able to save/export PDFs in order to send them to prospective employers.

Long wait time after new user registration before the registered user can log in.

Graduation date (in education section of portfolios) is passed through a date pipe for readability in admin components, but not in user components.