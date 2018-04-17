# powermocktest
This is a reproducer for the issue I'm getting with power mock and JDK9

With JDK 8 it works fine:

```
mvn clean install
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for powermock-test:powermock-test:jar:1.0-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 43, column 21
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building powermock-test 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ powermock-test ---
[INFO] Deleting /Users/mpogrebinsky/Development/powermocktest/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ powermock-test ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ powermock-test ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /Users/mpogrebinsky/Development/powermocktest/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ powermock-test ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/mpogrebinsky/Development/powermocktest/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ powermock-test ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /Users/mpogrebinsky/Development/powermocktest/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ powermock-test ---
[INFO] Surefire report directory: /Users/mpogrebinsky/Development/powermocktest/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running PowermockTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.013 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ powermock-test ---
[INFO] Building jar: /Users/mpogrebinsky/Development/powermocktest/target/powermock-test-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ powermock-test ---
[INFO] Installing /Users/mpogrebinsky/Development/powermocktest/target/powermock-test-1.0-SNAPSHOT.jar to /Users/mpogrebinsky/.m2/repository/powermock-test/powermock-test/1.0-SNAPSHOT/powermock-test-1.0-SNAPSHOT.jar
[INFO] Installing /Users/mpogrebinsky/Development/powermocktest/pom.xml to /Users/mpogrebinsky/.m2/repository/powermock-test/powermock-test/1.0-SNAPSHOT/powermock-test-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.859 s
[INFO] Finished at: 2018-04-17T14:27:31-07:00
[INFO] Final Memory: 20M/306M
[INFO] ------------------------------------------------------------------------

```


However if I run maven with JDK 9

```
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-9.0.4.jdk/Contents/Home/ mvn clean install  -e
[INFO] Error stacktraces are turned on.
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for powermock-test:powermock-test:jar:1.0-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 43, column 21
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building powermock-test 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ powermock-test ---
[INFO] Deleting /Users/mpogrebinsky/Development/powermocktest/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ powermock-test ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ powermock-test ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /Users/mpogrebinsky/Development/powermocktest/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ powermock-test ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/mpogrebinsky/Development/powermocktest/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ powermock-test ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /Users/mpogrebinsky/Development/powermocktest/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ powermock-test ---
[INFO] Surefire report directory: /Users/mpogrebinsky/Development/powermocktest/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running PowermockTest
Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.268 sec <<< FAILURE!
initializationError(PowermockTest)  Time elapsed: 0.006 sec  <<< ERROR!
org.objenesis.ObjenesisException: java.lang.reflect.InvocationTargetException
        at org.objenesis.instantiator.sun.SunReflectionFactoryHelper.newConstructorForSerialization(SunReflectionFactoryHelper.java:54)
        at org.objenesis.instantiator.sun.SunReflectionFactoryInstantiator.<init>(SunReflectionFactoryInstantiator.java:41)
        at org.objenesis.strategy.StdInstantiatorStrategy.newInstantiatorOf(StdInstantiatorStrategy.java:67)
        at org.objenesis.ObjenesisBase.getInstantiatorOf(ObjenesisBase.java:94)
        at org.powermock.reflect.internal.WhiteboxImpl.newInstance(WhiteboxImpl.java:259)
        at org.powermock.reflect.Whitebox.newInstance(Whitebox.java:139)
        at org.powermock.tests.utils.impl.AbstractTestSuiteChunkerImpl.getPowerMockTestListenersLoadedByASpecificClassLoader(AbstractTestSuiteChunkerImpl.java:95)
        at org.powermock.modules.junit4.common.internal.impl.JUnit4TestSuiteChunkerImpl.createDelegatorFromClassloader(JUnit4TestSuiteChunkerImpl.java:174)
        at org.powermock.modules.junit4.common.internal.impl.JUnit4TestSuiteChunkerImpl.createDelegatorFromClassloader(JUnit4TestSuiteChunkerImpl.java:48)
        at org.powermock.tests.utils.impl.AbstractTestSuiteChunkerImpl.createTestDelegators(AbstractTestSuiteChunkerImpl.java:108)
        at org.powermock.modules.junit4.common.internal.impl.JUnit4TestSuiteChunkerImpl.<init>(JUnit4TestSuiteChunkerImpl.java:71)
        at org.powermock.modules.junit4.common.internal.impl.AbstractCommonPowerMockRunner.<init>(AbstractCommonPowerMockRunner.java:36)
        at org.powermock.modules.junit4.PowerMockRunner.<init>(PowerMockRunner.java:34)
        at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:488)
        at org.junit.internal.builders.AnnotatedBuilder.buildRunner(AnnotatedBuilder.java:104)
        at org.junit.internal.builders.AnnotatedBuilder.runnerForClass(AnnotatedBuilder.java:86)
        at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:59)
        at org.junit.internal.builders.AllDefaultPossibilitiesBuilder.runnerForClass(AllDefaultPossibilitiesBuilder.java:26)
        at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:59)
        at org.junit.internal.requests.ClassRequest.getRunner(ClassRequest.java:33)
        at org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:250)
        at org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)
        at org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)
        at org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)
        at org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)
        at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)
        at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)
Caused by: java.lang.reflect.InvocationTargetException
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.objenesis.instantiator.sun.SunReflectionFactoryHelper.newConstructorForSerialization(SunReflectionFactoryHelper.java:44)
        ... 34 more
Caused by: java.lang.IllegalAccessError: class jdk.internal.reflect.ConstructorAccessorImpl loaded by org/powermock/core/classloader/MockClassLoader cannot access jdk/internal/reflect superclass jdk.internal.reflect.MagicAccessorImpl
        at java.base/java.lang.ClassLoader.defineClass1(Native Method)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1007)
        at org.powermock.core.classloader.MockClassLoader.loadUnmockedClass(MockClassLoader.java:262)
        at org.powermock.core.classloader.MockClassLoader.loadModifiedClass(MockClassLoader.java:206)
        at org.powermock.core.classloader.DeferSupportingClassLoader.loadClass1(DeferSupportingClassLoader.java:89)
        at org.powermock.core.classloader.DeferSupportingClassLoader.loadClass(DeferSupportingClassLoader.java:79)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:496)
        at java.base/java.lang.ClassLoader.defineClass1(Native Method)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1007)
        at org.powermock.core.classloader.MockClassLoader.loadUnmockedClass(MockClassLoader.java:262)
        at org.powermock.core.classloader.MockClassLoader.loadModifiedClass(MockClassLoader.java:206)
        at org.powermock.core.classloader.DeferSupportingClassLoader.loadClass1(DeferSupportingClassLoader.java:89)
        at org.powermock.core.classloader.DeferSupportingClassLoader.loadClass(DeferSupportingClassLoader.java:79)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:496)
        at java.base/jdk.internal.misc.Unsafe.defineClass0(Native Method)
        at java.base/jdk.internal.misc.Unsafe.defineClass(Unsafe.java:1173)
        at java.base/jdk.internal.reflect.ClassDefiner.defineClass(ClassDefiner.java:63)
        at java.base/jdk.internal.reflect.MethodAccessorGenerator$1.run(MethodAccessorGenerator.java:400)
        at java.base/jdk.internal.reflect.MethodAccessorGenerator$1.run(MethodAccessorGenerator.java:394)
        at java.base/java.security.AccessController.doPrivileged(Native Method)
        at java.base/jdk.internal.reflect.MethodAccessorGenerator.generate(MethodAccessorGenerator.java:393)
        at java.base/jdk.internal.reflect.MethodAccessorGenerator.generateSerializationConstructor(MethodAccessorGenerator.java:112)
        at java.base/jdk.internal.reflect.ReflectionFactory.generateConstructor(ReflectionFactory.java:434)
        at java.base/jdk.internal.reflect.ReflectionFactory.newConstructorForSerialization(ReflectionFactory.java:404)
        at jdk.unsupported/sun.reflect.ReflectionFactory.newConstructorForSerialization(ReflectionFactory.java:103)
        ... 39 more


Results :

Tests in error: 
  initializationError(PowermockTest): java.lang.reflect.InvocationTargetException

Tests run: 1, Failures: 0, Errors: 1, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.333 s
[INFO] Finished at: 2018-04-17T14:28:38-07:00
[INFO] Final Memory: 14M/49M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test (default-test) on project powermock-test: There are test failures.
[ERROR] 
[ERROR] Please refer to /Users/mpogrebinsky/Development/powermocktest/target/surefire-reports for the individual test results.
[ERROR] -> [Help 1]
org.apache.maven.lifecycle.LifecycleExecutionException: Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test (default-test) on project powermock-test: There are test failures.

Please refer to /Users/mpogrebinsky/Development/powermocktest/target/surefire-reports for the individual test results.
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:212)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:153)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:145)
        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:116)
        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:80)
        at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:51)
        at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
        at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:307)
        at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:193)
        at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:106)
        at org.apache.maven.cli.MavenCli.execute(MavenCli.java:863)
        at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:288)
        at org.apache.maven.cli.MavenCli.main(MavenCli.java:199)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
        at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
        at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
        at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
Caused by: org.apache.maven.plugin.MojoFailureException: There are test failures.

Please refer to /Users/mpogrebinsky/Development/powermocktest/target/surefire-reports for the individual test results.
        at org.apache.maven.plugin.surefire.SurefireHelper.reportExecution(SurefireHelper.java:83)
        at org.apache.maven.plugin.surefire.SurefirePlugin.writeSummary(SurefirePlugin.java:176)
        at org.apache.maven.plugin.surefire.SurefirePlugin.handleSummary(SurefirePlugin.java:150)
        at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeAfterPreconditionsChecked(AbstractSurefireMojo.java:650)
        at org.apache.maven.plugin.surefire.AbstractSurefireMojo.execute(AbstractSurefireMojo.java:586)
        at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:134)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:207)
        ... 20 more
[ERROR] 
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```
