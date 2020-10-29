# forge-generation-service
Spring server for portfolio generation and distribution

## Current bugs/functionality gaps:

1) Unable to create a new portfolio from the UI. Clicking the "Create a Portfolio" button brings up an existing portfolio. Need to create a new portfolio object and a blank portfolio view.

2) When editing an existing portfolio, changes to industry equivalency, skill matrix, and all aspects of projects (except project names) do not persist. Deleting a project does not persist.

3) Unable to add more than one degree to the education section; if a degree is already listed, the add button will replace the existing entry with a new one.

4) PDF functionality does not exist on the front end. Admins should be able to save PDFs as well in order to send them to prospective employers.

5) Long wait time after new user registration before the registered user can log in.

6) Graduation date is passed through a date pipe for readability in admin components, but not in user components.
