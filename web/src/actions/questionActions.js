export const LOADING = 'LOADING'
export const LOADED_SUCCESS = 'LOADED_SUCCESS'

export const LOADED_FAILURE = 'LOADED_FAILURE'

export const loading = () => ({ type: LOADING })

export const success = payload => ({
    type: LOADED_SUCCESS,
    payload
});

export const failure = () => ({ type: LOADED_FAILURE })

export function fetchQuestions() {
    return async dispatch => {
        dispatch(loading())
        try {
            const response = await fetch(
                `http://localhost:8080/getAll`
            )
            const data = await response.json()
            dispatch(success({questions: data}))
        } catch (error) {
            dispatch(failure())
        }
    }
}

export function fetchQuestion(id) {
    return async dispatch => {
        dispatch(loading())
        try {
            const response = await fetch(
                `http://localhost:8080/get/${id}`
            )
            const data = await response.json()
            dispatch(success({question: data}))
        } catch (error) {
            dispatch(failure())
        }
    }
}
