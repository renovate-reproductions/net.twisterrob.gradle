package net.twisterrob.gradle.quality.gather

import com.android.build.gradle.tasks.LintBaseTask
import com.android.build.gradle.tasks.LintGlobalTask
import com.android.build.gradle.tasks.LintPerVariantTask
import net.twisterrob.gradle.common.Constants
import net.twisterrob.gradle.common.Utils
import se.bjurr.violations.lib.model.Violation
import se.bjurr.violations.lib.reports.Parser

class LintReportGatherer<T extends LintBaseTask> extends TaskReportGatherer<T> {

	@Override
	File getReportLocation(T task) {
		if (task instanceof LintGlobalTask) {
			return Utils.getXmlOutput(task)
		} else if (task instanceof LintPerVariantTask) {
			return Utils.getXmlOutput(task)
		} else {
			throw new IllegalArgumentException("${task.path} (${task.class}) is not recognized as a lint task")
		}
	}

	@Override
	String getName(T task) {
		if (task instanceof LintGlobalTask) {
			return Constants.ALL_VARIANTS_NAME
		} else if (task instanceof LintPerVariantTask) {
			return task.variantName
		} else {
			throw new IllegalArgumentException("${task.path} (${task.class}) is not recognized as a lint task")
		}
	}

	@Override
	List<Violation> findViolations(File report) {
		return Parser.ANDROIDLINT.findViolations(Collections.<File> singletonList(report))
	}
}
