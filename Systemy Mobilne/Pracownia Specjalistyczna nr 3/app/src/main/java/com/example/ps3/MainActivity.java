package com.example.ps3;

import androidx.fragment.app.Fragment;
import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        UUID id = (UUID) getIntent().getSerializableExtra(TaskListFragment.KEY_EXTRA_TASK_ID);
        return TaskFragment.newInstance(id);
    }
}