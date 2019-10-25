package technolifestyle.com.kotlinPractice.asyncTask

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_async_task.*
import java.lang.ref.WeakReference

class AsyncTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(technolifestyle.com.kotlinPractice.R.layout.activity_async_task)

        /*
            AsyncTask executed in Serial by default
            Output would be: C, A, B
         */
        TestAsyncTask(this).execute("C", "3000")
        TestAsyncTask(this).execute("A", "5000")
        TestAsyncTask(this).execute("B", "2000")

        /*
            AsyncTask executed in Parallel using THREAD_POOL_EXECUTOR
            Output would be: B, C, A
         */
//        TestAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "C", "3000")
//        TestAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "A", "5000")
//        TestAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "B", "2000")
    }

    companion object {
        var count = 0

        class TestAsyncTask(activity: AsyncTaskActivity) : AsyncTask<String, Void, Pair<String?, String?>>() {
            private val mWeakActivity: WeakReference<AsyncTaskActivity> = WeakReference(activity)

            override fun doInBackground(vararg params: String?): Pair<String?, String?> {
                count++
                val time = params[1]?.toLong() ?: 1
                Thread.sleep(time)
                Log.d("Async Task", "Printing numbers: ${params[0]}")
                return Pair(params[0], params[1])
            }

            override fun onPostExecute(result: Pair<String?, String?>) {
                super.onPostExecute(result)
                when (count) {
                    1 -> {
                        mWeakActivity.get()?.firstTaskText?.text = result.first
                        mWeakActivity.get()?.firstTaskTime?.text = "${result.second}ms"
                    }
                    2 -> {
                        mWeakActivity.get()?.secondTaskText?.text = result.first
                        mWeakActivity.get()?.secondTaskTime?.text = "${result.second}ms"
                    }
                    3 -> {
                        mWeakActivity.get()?.thirdTaskText?.text = result.first
                        mWeakActivity.get()?.thirdTaskTime?.text = "${result.second}ms"
                    }
                }
            }
        }
    }
}
