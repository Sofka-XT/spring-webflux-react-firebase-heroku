import React, { useEffect } from 'react'
import { connect } from 'react-redux'

import { fetchQuestion } from '../actions/questionActions'

import { Question } from '../components/Question'
import { Answer } from '../components/Answer'

const SingleQuestionPage = ({
  match,
  dispatch,
  question,
  answers,
  hasErrors,
  loading,
}) => {
  useEffect(() => {
    const { id } = match.params
    dispatch(fetchQuestion(id))
  }, [dispatch, match])

  const renderQuestion = () => {
    if (loading.question) return <p>Loading question...</p>
    if (hasErrors.question) return <p>Unable to display question.</p>

    return <Question question={question} />
  }

  const renderAnswers = () => {
    return answers.map(answer => (
      <Answer key={answer.id} answer={answer} />
    ))
  }

  return (
    <section>
      {renderQuestion()}
      <h2>Answers</h2>
      {renderAnswers()}
    </section>
  )
}

const mapStateToProps = state => ({
  question: state.question.question,
  answer: state.question.question.answers,
  loading: state.question.loading,
  hasErrors: state.question.hasErrors
})

export default connect(mapStateToProps)(SingleQuestionPage)
