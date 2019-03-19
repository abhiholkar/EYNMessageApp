# EYNMessageApp

EYNMessageApp is for demo purpose. The app  expects user to write text on Editfield and then uses open URL "http://ptsv2.com/" and post(text) the data on server.
The posted data can be viewed at :  " http://ptsv2.com//t/EYN/post ". On successful post app , show Toast message showing Post success.
In case network is not available the data is cached using shared preferences and then posted when network is available. 
The data is delimited using the pipe("|") character. On successful cache entry app shows Toast message showing Caching success.


# Application Architecture.
- Application uses MVVM architecture & CLEAN architecture & principles of SOLID programming.
- Retrofit is used for Network layer.
- RxJava2 is used for Background/Asychronous operations 
- GSON library is used for parsing of data

# Pre-Requiste
- Android studio . Kotlin

# Run/Test
- App has been tested on device.

# Techincal Debt
- Add capability to post Images/ Vidoes
- Add capability to post in background using broadcast receiver/Service & add timestamp for cache data.

# Known bug
- Resilience



