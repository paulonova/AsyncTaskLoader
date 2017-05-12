# AsyncTaskLoader
AsynkTaskLoader MODEL
So this is the recipe that you want, to use a loader to make calls over the web. Again the AsyncTaskLoader is doing 
basically the same thing as AsyncTask, but because it's using the loader architecture, if you're running a slightly 
longer task you won't risk losing the task on configuration changes such as when the device is changed from portrait 
to landscape or back again. There's yet another architecture though that's worth knowing about that works well with very long tasks. 
Such as downloading large datasets or files.

And unlike either AsyncTask or AsyncTaskLoader, it's completely decoupled from activities, fragments and other user interface components
