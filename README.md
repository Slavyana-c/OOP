# COMP1721 Practical Work

This repository contains your exercise and coursework solutions for
[COMP1721 Object-Oriented Programming](http://comp1721.info).

Please remember to

* Use the appropriate directories for your work

* Begin each work session by grabbing any changes you don't yet have in your local repository, using `git pull origin master`

* Commit changes to your local repository frequently and use sensible commit messages

* Push those changes up to the remote master repository at the end of a work session, using `git push origin master`

## Coursework Submission

This is a two-step process.

1.  Use the `finished` script at the top level of your repository, with an
    argument of either `cwk1` or `cwk2`, to register your coursework solution.

    For example, to register your Coursework 1 solution, enter `./finished cwk1`.
    This will tag your solution in GitLab so that we can recognise it,
    schedule it for testing and finally create a Zip archive called `cwk1.zip`.

    Note that this script requires a bash shell and the git & zip command
    line tools.  It will run in a terminal window on Linux PCs and Macs.
    **Windows is not supported for coursework submission purposes.**
    ([Bash on Ubuntu on Windows](https://msdn.microsoft.com/en-gb/commandline/wsl/about)
    will probably work, but has not been tested.)

2.  Upload the Zip archive that was generated by the script to Minerva.

    **Note that you MUST do this in order to formally submit your work.**
    Failure to do so will delay marking of your work and incur a penalty.

### If you make a mistake...

If you need to make further changes to your solution after having performed
the steps listed above, you will first need to remove the relevant tag from
your repository using two Git commands.  For Coursework 1, these commands
are
```
git tag -d cwk1
git push origin :refs/tags/cwk1
```
(For Coursework 2, simply replace `cwk1` with `cwk2` in the above.)

You should now be able to run `finished` again without errors.  After doing
this, don't forget to upload the new version of `cwk1.zip` or `cwk2.zip`
to Minerva!
