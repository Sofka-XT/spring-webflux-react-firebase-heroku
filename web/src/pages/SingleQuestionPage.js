import React, { useEffect } from 'react'
import { connect } from 'react-redux'

import { fetchQuestion } from '../actions/questionActions'

import { Question } from '../components/Question'
import { Answer } from '../components/Answer'

const SingleQuestionPage = ({
  match,
  dispatch,
  question,
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
    return (question.answers && question.answers.length) && question.answers.map(answer => (
      <Answer key={answer.id} answer={answer} />
    )) || <p>Empty answer!</p>;
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
  loading: state.question.loading,
  hasErrors: state.question.hasErrors
})

export default connect(mapStateToProps)(SingleQuestionPage)
