## Heroku Command

Check PORT and PROFILE on [Procfile](Procfile)

  `git remote add heroku -f <openshift-git-repo-url>`

  `git push heroku master`

## Openshift

Check the deploy files
  [deploy](.openshift/action_hooks/deploy)
  [start](.openshift/action_hooks/start)
  [stop](.openshift/action_hooks/stop)

  `git remote add openshift -f <openshift-git-repo-url>`

  `git merge openshift/master -s recursive -X ours`

  `git push openshift master`

