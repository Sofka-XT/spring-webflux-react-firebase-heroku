import React from 'react'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from 'react-router-dom'

import { Navbar } from './components/Navbar'
import HomePage from './pages/HomePage'
import QuestionsPage from './pages/QuestionsPage'


const App = () => {
  return (
    <Router>
      <Navbar />
      <Switch>
        <Route exact path="/" component={HomePage} />
        <Route exact path="/questions" component={QuestionsPage} />
        <Redirect to="/" />
      </Switch>
    </Router>
  )
}

export default App
