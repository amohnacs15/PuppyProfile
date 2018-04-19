## PuppyProfile

Adroid application that connects to a Stackoverflow Users API Endpoint and populates a RecyclerView.  Model View Presenter design pattern following clean architecuture to ensure the seperation of responsibilities.

### Third Party Libraries Used

#### Retrofit 2

Retrofit is used as our HTTP Client to reduce on development time and to take advantage of Retrofit's compatability with GSON to map our json response into POJOS.  Retrofit handles the connections, retry protocol, caching, threading, and error handling.
If we wanted to do this on our own we would need to build and manage our own asynchronous HTTP requests.  The requests and header would be built and added to a request queue.

#### Glide

Again, Glide handles caching and converting our json response into a usable object.  If we wanted to implement our own image caching we would save the seriealized bitmap value and store in an SQLiteDatabase along with other user information.  On our initial request to get user data and image data we would check our cache first.  If it's not empty then we get our data locally and BitmapFactory decodes our byte array into a Bitmap.

![screenshot_20180322-213350](https://user-images.githubusercontent.com/7444521/39014949-af9d9e2a-43d0-11e8-8800-d93a171b193d.png)
