WITH templow AS (
    SELECT s1.student_id, s1.subject, s1.exam_date AS first_exam_date, s1.score AS first_score
    FROM Scores s1
    WHERE s1.exam_date = (
        SELECT MIN(s2.exam_date)
        FROM Scores s2
        WHERE s2.student_id = s1.student_id AND s2.subject = s1.subject
    )
),
temphigh AS (
    SELECT s1.student_id, s1.subject, s1.exam_date AS latest_exam_date, s1.score AS latest_score
    FROM Scores s1
    WHERE s1.exam_date = (
        SELECT MAX(s2.exam_date)
        FROM Scores s2
        WHERE s2.student_id = s1.student_id AND s2.subject = s1.subject
    )
)

SELECT h.student_id, h.subject, l.first_score, h.latest_score
FROM temphigh h
LEFT JOIN templow l 
ON h.student_id = l.student_id AND h.subject = l.subject
WHERE h.latest_score > l.first_score
ORDER BY  h.student_id, h.subject;
