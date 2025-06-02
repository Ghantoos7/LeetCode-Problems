# Write your MySQL query statement below


SELECT l.book_id , l.title, l.author,l.genre, l.publication_year ,l.total_copies as current_borrowers 
FROM borrowing_records b
LEFT JOIN library_books l on b.book_id = l.book_id 
WHERE b.return_date IS NULL 
GROUP BY b.book_id 
HAVING (COUNT(*) = AVG(l.total_copies)) 
ORDER BY current_borrowers DESC, l.title