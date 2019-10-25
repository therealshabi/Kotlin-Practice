package technolifestyle.com.kotlinPractice.asyncTask

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import technolifestyle.com.kotlinPractice.R

class AsyncTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        /*
            AsyncTask executed in Serial by default
            Output would be: C, A, B
         */
        TestAsyncTask().execute("C", "3000")
        TestAsyncTask().execute("A", "5000")
        TestAsyncTask().execute("B", "2000")

        /*
            AsyncTask executed in Parallel using THREAD_POOL_EXECUTOR
            Output would be: B, C, A
         */
        TestAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "C", "3000")
        TestAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "A", "5000")
        TestAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "B", "2000")
    }

    companion object {
        class TestAsyncTask : AsyncTask<String, Void, Void>() {
            override fun doInBackground(vararg params: String?): Void? {
                val time = params[1]?.toLong() ?: 1
                Thread.sleep(time)
                Log.d("Async Task", "Printing numbers: ${params[0]}")
                return null
            }
        }
    }
}
