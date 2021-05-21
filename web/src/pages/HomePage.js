import React from 'react'
import { Link } from 'react-router-dom'

const HomePage = () => (
  <section>
    <h1>Home</h1>
    <p>This is the home.</p>
    <Link to="/questions" className="button">
      View Questions
    </Link>
  </section>
)

export default HomePage
